import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

@XmlRootElement
public class Output implements Serializable{
	private List<BigInteger> fibonacci;
	private List<BigInteger> sorted;
	private static final long serialVersionUID = -9130603850117689481L;
	
	public Output() {};
	
	public Output(List<BigInteger> fibonacci, List<BigInteger> sorted) {
		this.fibonacci = fibonacci;
		this.sorted = sorted;
	}
	
	public void setFibonacci(List<BigInteger> fibonacci) {
		this.fibonacci = fibonacci;
	}
	
	public List<BigInteger> getFibonacci() {
		return this.fibonacci;
	}
	
	public void setSorted(List<BigInteger> sorted) {
		this.sorted = sorted;
	}
	
	public List<BigInteger> getSorted() {
		return this.sorted;
	}
}
