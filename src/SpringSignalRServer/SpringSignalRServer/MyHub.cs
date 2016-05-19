﻿using System;
using System.Threading.Tasks;
using Microsoft.AspNet.SignalR;

namespace SpringSignalRServer
{
    public class MyHub : Hub
    {
        public void Send(string name, string message)
        {
            Clients.All.addMessage(name, message);
        }

        public override Task OnConnected()
        {
            Console.WriteLine("Client connected.");
            return Task.CompletedTask;
        }
    }
}
