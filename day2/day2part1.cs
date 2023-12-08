using System.Text.RegularExpressions;

class Day2Part1
{
    static void Main(string[] args)
    {
        int count = 0;

        StreamReader sr = new StreamReader("input.txt");
        string line = sr.ReadLine();

        while (line != null)
        {
            int red, green, blue;
            red = green = blue = 0;

            string[] lineParts = line.Split(',', ':', ';');

            foreach (var part in lineParts)
            {
                red = ProcessColor(part, "red", red);
                green = ProcessColor(part, "green", green);
                blue = ProcessColor(part, "blue", blue);
            }

            count = IncreaseSumIfValidNum(red, green, blue, lineParts, count);
            line = sr.ReadLine();
        }

        sr.Close();
        Console.WriteLine("Final " + count);
        Console.ReadLine();
    }

    static int ProcessColor(string part, string color, int value)
    {
        if (part.Contains(color))
        {
            string resultString = Regex.Match(part, @"\d+").Value;
            if (int.TryParse(resultString, out int intValue) && intValue > value)
            {
                value = intValue; // find highest value for each colour in each game
            }
        }
        return value;
    }

    static int IncreaseSumIfValidNum(int red, int green, int blue, string[] lineParts, int count)
    {
        if (red < 13 && green < 14 && blue < 15)
        {
            Console.WriteLine("Possible ID: " + lineParts[0]);
            Console.WriteLine($"Red: {red} Green: {green} Blue: {blue}");

            if (int.TryParse(Regex.Match(lineParts[0], @"\d+").Value, out int intValue))
            {
                count += intValue;
            }
        }
        return count;
    }
}
