using System;
using System.Threading.Tasks;
using Microsoft.AspNet.SignalR;

namespace SpringSignalRServer
{
    public class GameHub : Hub
    {
        public void Send(string name, string message)
        {
            Clients.All.addMessage(name, message);
        }

        public void Update(int frame)
        {
            Console.WriteLine($"Update called. Frame: {frame}");
        }

        public override Task OnConnected()
        {
            Console.WriteLine($"Client connected {Context.ConnectionId}");
            return base.OnConnected();
        }

        public override Task OnDisconnected(bool stopCalled)
        {
            Console.WriteLine($"Client disconnected {Context.ConnectionId}");
            return base.OnDisconnected(stopCalled);
        }
    }
}
