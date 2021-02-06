using System;

namespace ConsoleApp1
{
    class Program
    {
        static void Main(string[] args)
        {
            // Create list of company names from the file
            List<string> company_names_from_file = File.ReadAllLines(@"C:\Users\randy\source\repos\coding_challenge\Pathmatics Challenge\FindDuplicateEntry\advertisers.txt").ToList()

            // Preprocess all company entries by removing all nonalphanumeric values and convert casing to lowercase
            List<String> processed_company_names = new ArrayList<String>();
            for (String original_name_entry : company_names_from_file)
            {
                company_names_from_file.add(original_name_entry.replaceAll("[\\W]|_", "").toLowerCase());
            }




            Map<String, List<Integer>> map = new HashMap();
            for (int index_of_company_name = 0; index_of_company_name < processed_company_names.size(); index_of_company_name++) {
                String index = companyNames.get(index_of_company_name);
                if (map.containsKey(index)) {
                    List<Integer> indexes = map.get(index);
                    indexes.add(index_of_company_name);
                } else {
                    List<Integer> value = new ArrayList<Integer>();
                    value.add(index_of_company_name);
                    map.put(key, value);
                }
            }

            List<Integer> duplicateIndexes = new ArrayList<Integer>();
            Collection<List<Integer>> indexesOfAll = map.values();
            for (List<Integer> indexesOfCompanyNames : indexesOfAll) {
                //if size > 1 then it is duplicate indexes
                if (indexesOfCompanyNames.size() > 1) {
                    duplicateIndexes.addAll(indexesOfCompanyNames);
                }
            }

            File outputFile = new File("C:/some directory");
            try (FileOutputStream outputStream = new FileOutputStream(outputFile)) {
                for (Integer indexOfDuplicate : duplicateIndexes) {
                    outputStream.write(originalNames.get(indexOfDuplicate).getBytes());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
