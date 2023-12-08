using System.Text.RegularExpressions;

class Day2Part2
{
    static void Main(string[] args)
    {
        StreamReader sr = new StreamReader("input.txt");
        string line = sr.ReadLine();

        int sum = 0;

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

            sum = getPower(red, green, blue, sum);


            line = sr.ReadLine();
        }

        sr.Close();
        Console.WriteLine("Sum: " + sum);
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

    static int getPower(int red, int green, int blue, int sum)
    {
        int power = red * green * blue;

        return sum + power;
    }
}
