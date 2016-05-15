using System;
using Microsoft.Owin.Hosting;

namespace SpringSignalRServer
{
    class Program
    {
        static void Main(string[] args)
        {
            string url = "http://*:8080";
            using (WebApp.Start(url))
            {
                Console.WriteLine("Server running on {0}", url);
                Console.WriteLine("Press any key to exit.");
                Console.ReadKey();
            }
        }
    }
}
