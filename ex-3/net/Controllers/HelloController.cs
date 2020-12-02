using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;

namespace OwMyAws.Controllers
{
    [Route("/")]
    [ApiController]
    public class HelloController : ControllerBase
    {
        private readonly ILogger<HelloController> _logger;

        public HelloController(ILogger<HelloController> logger)
        {
            _logger = logger;
        }

        // GET api/values
        [HttpGet]
        public ActionResult<string> Get()
        {
            _logger.LogInformation($"Received request: {Request.Method} {Request.Path}");
            var response = "Hello from .Net!";
            _logger.LogInformation($"Returning: {response}");
            return response;
        }
    }
}