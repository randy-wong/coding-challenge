using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;

namespace FindDuplicateEntriesWithOutHash
{
    class Program
    {
        static void Main(string[] args)
        {
            // first find two duplicate records 
            // pasted .txt into notepad++ 
            // removed extra caracters https://stackoverflow.com/questions/43334055/notepad-remove-non-alpanumeric-characters
            // 

            // does it encapsulate?
            // what percentage similarity is it
            // does size of the word matter?
            // how many capitalization
            // 


            // sort it 
            // Resources
            // https://docs.microsoft.com/en-us/dotnet/csharp/programming-guide/file-system/how-to-read-from-a-text-file
            // 
            // Example #2
            // Read each line of the file into a string array. Each element
            // of the array is one line of the file.
            string[] company_names = System.IO.File.ReadAllLines(@"C:\Users\randy\source\repos\coding_challenge\Pathmatics Challenge\FindDuplicateEntriesWithOutHash\advertisers.txt");
            Array.Sort(company_names);

            for (int i = 0; i < company_names.Length; i++)
            {
                if (i == company_names.Length - 1)
                {
                    break;
                }

                double comparison_rate = 0;
                // Console.WriteLine(company_names[i]);
                // Console.WriteLine(company_names[i + 1]);

                // Tokenize by case
                // https://stackoverflow.com/questions/36147162/c-sharp-string-split-separate-string-by-uppercase?lq=1
                string[] compare1 = Regex.Split(company_names[i], @"(?<!^)(?=[A-Z])");
                string[] compare2 = Regex.Split(company_names[i + 1], @"(?<!^)(?=[A-Z])");

                // Maybe try Language Integrated Query (LINQ)?
                // Compare each token
                for (int j = 0; j < compare1.Length; j++)
                {
                    for (int k = 0; k <compare2.Length; k++)
                    {
                        if(compare1[j] == compare2[k])
                        {
                            comparison_rate++;
                        }
                    }

                }

                if (comparison_rate != 0 && (comparison_rate < ((compare1.Length + compare2.Length) / 2)))
                {
                    Console.WriteLine("Comparison Rate: " + comparison_rate + " : " + company_names[i] + " and " + company_names[i + 1] + " are similar.");
                }





            }



            // Display the file contents by using a foreach loop.
            // System.Console.WriteLine(company_names[0]);

            System.Console.ReadKey();
        }
    }
}