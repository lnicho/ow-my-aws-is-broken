using Microsoft.AspNetCore.Mvc;

namespace OwMyAws.Controllers
{
    [Route("/")]
    [ApiController]
    public class HelloController : ControllerBase
    {
        // GET api/values
        [HttpGet]
        public ActionResult<string> Get()
        {
            return "Hello from .Net!";
        }
    }
}