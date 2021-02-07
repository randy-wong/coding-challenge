using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;

namespace FindDuplicateEntriesWithOutHash
{
    class Program
    {
        static void Main(string[] args)
        {
            // First find two duplicate records 
            // Pasted .txt into notepad++ 
            // Removed extra caracters https://stackoverflow.com/questions/43334055/notepad-remove-non-alpanumeric-characters
            // 

            // Does it encapsulate?
            // What percentage similarity is it?
            // Does size of the word matter?
            // How many of the string tokens are capitalization?
            // 

            // Resources
            // https://docs.microsoft.com/en-us/dotnet/csharp/programming-guide/file-system/how-to-read-from-a-text-file
            // 

            // Read each line of the file into a string array. Each element
            // of the array is one line of the file.
            string[] company_names = System.IO.File.ReadAllLines(@"C:\Users\randy\source\repos\coding_challenge\Pathmatics Challenge\FindDuplicateEntriesWithOutHash\advertisers.txt");

            // Sort the array
            Array.Sort(company_names);

            // Testing space
            string[] a = Normalize("20th Century Fox Television");
            string[] b = Normalize("20th Century Fox Studios(foxmovies.com)");
            Compare(a, b);


            // Iterate through the array
            for (int i = 0; i < company_names.Length; i++)
            {
                // Stop at the last element
                if (i == company_names.Length - 1)
                {
                    break;
                }

                // double comparison_rate = 0;
                // Console.WriteLine(company_names[i]);
                // Console.WriteLine(company_names[i + 1]);

                string company_to_compare1 = company_names[i];
                string company_to_compare2 = company_names[i + 1];

                // Tokenize by case
                // https://stackoverflow.com/questions/36147162/c-sharp-string-split-separate-string-by-uppercase?lq=1
                // Console.WriteLine("Comparing " + company_names[i] + " and " + company_names[++i]);
                string[] compare1 = Normalize(company_to_compare1);
                string[] compare2 = Normalize(company_to_compare2);

                if (Compare(compare1, compare2))
                {
                    Console.WriteLine(company_to_compare1 + " and " + company_to_compare2 + " are similar.");
                }



                // if (comparison_rate != 0 && (comparison_rate < ((compare1.Length + compare2.Length) / 2)))
                // {
                //     Console.WriteLine("Comparison Rate: " + comparison_rate + " : " + company_names[i] + " and " + company_names[i + 1] + " are similar.");
                // }
            }



            // Display the file contents by using a foreach loop.
            // System.Console.WriteLine(company_names[0]);

            System.Console.ReadKey();
        }

        public static string[] Normalize(string index)
        {
            // Tokenize by case
            // https://stackoverflow.com/questions/36147162/c-sharp-string-split-separate-string-by-uppercase?lq=1
            return Regex.Split(index, @"(?<!^)(?=[A-Z])");
            // return Regex.Split(index, @"\D+");
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="compare1"></param>
        /// <param name="compare2"></param>
        /// <returns></returns>
        public static bool Compare(string[] compare1, string[] compare2)
        {
            // Maybe try Language Integrated Query (LINQ)?
            // Compare each token

            if (compare1[0] != compare2[0])
            {
                return false;
            }

            else
            {
                int comparison_rate = 1;
                int token_size = (compare1.Length <= compare2.Length) ? token_size = compare1.Length : token_size = compare2.Length;
                for (int i = 1; i < token_size; i++)
                {
                    if (compare1[i] == compare2[i])
                    {
                        comparison_rate++;
                    }
                }
                if (comparison_rate > (compare2.Length / 2))
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }

            /*
            for (int j = 0; j < compare1.Length; j++)
            {
                for (int k = 0; k < compare2.Length; k++)
                {
                    System.Console.WriteLine(compare1[j] + " comparing " + compare2[k]);
                    if (compare1[j] == compare2[k])
                    {

                        comparison_rate++;
                    }
                }
            } 
            */
        }

    }
}