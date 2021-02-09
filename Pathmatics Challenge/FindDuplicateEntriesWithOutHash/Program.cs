using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;

namespace FindDuplicateEntriesWithOutHash
{
    interface FindDuplicates
    {
        // Input should be ideally any datasource
        //
        void Input();
        // Scub out data for duplicate entries with slightly different names
        // E.G.: "1-800-Flowers.com" and "1800Flowers.com"
        // https://stackoverflow.com/questions/6400416/figure-out-if-a-business-name-is-very-similar-to-another-one-python
        //

        string[] Normalize(string compare1);
        // Does it encapsulate?
        // What percentage similarity is it?
        // Does size of the word matter?
        // How many of the string tokens are capitalization?
        // 

        bool Compare(string[] compare1, string[] compare2);

        void Output(string str);
    }

    class WithoutHash : FindDuplicates
    {
        private string[] entries;
        public void Input()
        {
            // Resources: https://docs.microsoft.com/en-us/dotnet/csharp/programming-guide/file-system/how-to-read-from-a-text-file
            Console.WriteLine("Enter location of advertisers file:");
            string path = Console.ReadLine();
            // Read each line of the file into a string array. Each element
            // of the array is one line of the file.
            entries = System.IO.File.ReadAllLines(path);
            Array.Sort(entries);
            // string[] company_names = System.IO.File.ReadAllLines(@"C:\Users\randy\source\repos\coding_challenge\Pathmatics Challenge\FindDuplicateEntriesWithOutHash\advertisers.txt");
        }

        public string[] GetEntries()
        {
            return entries;
        }

        public string[] Normalize(string index)
        {
            // Tokenize by case
            // Cited code: https://stackoverflow.com/questions/36147162/c-sharp-string-split-separate-string-by-uppercase?lq=1
            return Regex.Split(index, @"(?<!^)(?=[A-Z])");
        }

        public bool Compare(string[] compare1, string[] compare2)
        {
            // Maybe try Language Integrated Query (LINQ)?
            // Compare each token

            // If the first element is not the same then return false
            if (compare1[0] != compare2[0])
            {
                return false;
            }

            else
            {

                // If the first element is the same then the comparison rate is set at 1
                double comparison_rate = 1;
                // Ternary statement to find the smaller value
                double smaller_word = (compare1.Length <= compare2.Length) ? smaller_word = compare1.Length : smaller_word = compare2.Length;
                double bigger_word = (compare1.Length > compare2.Length) ? bigger_word = compare1.Length : bigger_word = compare2.Length;
                for (int i = 1; i < smaller_word; i++)
                {
                    if (compare1[i] == compare2[i])
                    {
                        comparison_rate++;
                    }
                }
                if(bigger_word == smaller_word && comparison_rate == smaller_word)
                {
                    return true;
                }
                // Arbitrary way of comparing the what should be displayed
                // Half of the smaller input
                bool pass = comparison_rate >= (bigger_word / 2);
                if (pass && (comparison_rate > 2))
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }

        // Considering piping output to file
        public void Output(string str)
        {
            Console.WriteLine(str);
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            // First find two duplicate records 
            // Pasted .txt into notepad++ 
            // Removed extra caracters https://stackoverflow.com/questions/43334055/notepad-remove-non-alpanumeric-characters
            // 

            WithoutHash implementation_without_hash = new WithoutHash();
            implementation_without_hash.Input();
            string[] company_names = implementation_without_hash.GetEntries();

            // Iterate through the array
            for (int i = 0; i < company_names.Length; i++)
            {
                // Stop at the last element
                if (i == company_names.Length - 1)
                {
                    break;
                }

                string write;

                // Variables 
                string company_to_compare1 = company_names[i];
                string company_to_compare2 = company_names[i + 1];

                // Passing variables through Normalize function
                string[] compare1 = implementation_without_hash.Normalize(company_to_compare1);
                string[] compare2 = implementation_without_hash.Normalize(company_to_compare2);

                // Passing variables through Output function which also passes it through Compare function
                if (implementation_without_hash.Compare(compare1, compare2))
                {
                    write = company_to_compare1 + " and " + company_to_compare2 + " are similar.";
                    implementation_without_hash.Output(write);
                }
            }
            System.Console.ReadKey();
        }
    }
}