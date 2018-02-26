import java.util.List;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;

@Path("/generatefibonacci")
public class GenerateFibonacci {
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextHello() {
      return "There are two ways to use this Fibonacci Generator: \n"
      		+ "1. go to localhost:8080/Fibonacci/rest/generatefibonacci/calculate and POST a json file like following: \n"
      		+ "		{ elements:10 } \n"
      		+ "2. modify the path, like localhost:8080/Fibonacci/rest/generatefibonacci/calculate/10";
    }
	
	@POST
	@Path("/calculate")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Output insert(Input input) throws JSONException {
		int num = Integer.parseInt(input.getElements());
		List<BigInteger> fibonacci;
		List<BigInteger> sortedFibonacci;
		fibonacci = generate(num);
		sortedFibonacci = sorted(fibonacci);
		return new Output(fibonacci, sortedFibonacci);
    }
	
	@Path("{d}")
	@GET
	@Produces("application/json")
	public Response generateFibonacci(@PathParam("d") int d) throws JSONException {
 
		JSONObject jsonObject = new JSONObject();
		List<BigInteger> fibonacci;
		List<BigInteger> sortedFibonacci;
		fibonacci = generate(d);
		sortedFibonacci = sorted(fibonacci);
		jsonObject.put("fibonacci", fibonacci); 
		jsonObject.put("sorted", sortedFibonacci);

		String result = jsonObject.toString();
		return Response.status(200).entity(result).build();
	}
	
	//generate Fibonacci sequence with a input int num(number of elements) 
	public List<BigInteger> generate(int num) {
		List<BigInteger> fibonacci = new ArrayList<>();
		if(num >= 1) fibonacci.add(new BigInteger("0"));
		if(num >= 2) fibonacci.add(new BigInteger("1"));
		for(int i = 2; i < num; i ++) {
			fibonacci.add(fibonacci.get(i-2).add(fibonacci.get(i-1)));
		}
		return fibonacci;
	}
	//generate sorted sequence with Fibonacci sequence generated
	//Even numbers first in descending order then odd numbers in descending order 
	public List<BigInteger> sorted(List<BigInteger> fibonacci) {
		int size = fibonacci.size();
		BigInteger[] sortedFibonacci = new BigInteger[size];
		//index that point to location of next larger even number
		int even = (size - 1)/3 - 1;
		//index that point to location of next larger odd number
		int odd = size - 2;
		BigInteger two = new BigInteger("2");
		for(int i = 1; i < size; i++) {
			if(fibonacci.get(i).mod(two).intValue()==0) {
				sortedFibonacci[even] = fibonacci.get(i);
				even --;
			} else {
				sortedFibonacci[odd] = fibonacci.get(i);
				odd --;
			}
		}
		sortedFibonacci[size-1] = fibonacci.get(0);
		return Arrays.asList(sortedFibonacci);
	}
	
}

