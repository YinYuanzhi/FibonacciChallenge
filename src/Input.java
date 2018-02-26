import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class Input implements Serializable{
	private String elements;
	private static final long serialVersionUID = 6826191735682596960L;
	
	public Input() {};
	
	public Input(String elements) {
		this.elements = elements;
	}
	
	public void setElements(String elements) {
		this.elements = elements;
	}
	
	public String getElements() {
		return this.elements;
	}
}
