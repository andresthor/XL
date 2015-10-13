import util.*;
import model.*;
import expr.*;

public class GuiTerminal {
	XLModel model;

	public static void main(String[] args) {
		new GuiTerminal();
	}

	public GuiTerminal() {
		
		p("//new model");
		model = new XLModel();
		p("");

		p("// ADD Expression");
		model.addSlot("A1", "5");
		model.addSlot("B2", "A1 + 3");
		p("");

		p("// ADD Comment");
		model.addSlot("A2", "#kommentar");
		p("");
		
		p("// GET (double value)");
		p("A1: " + (double) model.value("A1"));
		p("B2: " + (double) model.value("B2"));
		p("A2: " + (double) model.value("A2"));
		p("");

		p("// GET String");
		p("A1: " + (String) model.getSlotString("A1"));
		p("B2: " + (String) model.getSlotString("B2"));
		p("A2: " + (String) model.getSlotString("A2"));
		p("");

		p("// Read empty slot");
		if (model.isEmpty("C1")) {
			p("C1 is empty");
		}
		//Throws exception
			try {
				p("C1: " + (double) model.value("C1"));
			} catch (XLException e) {
				status();
			}
		p("");

		p("///////Errors");

		p("// Add circular reference");
		model.addSlot("A1", "A1");
		status();
		p("A1: " + (String) model.getSlotString("A1"));
		p("");

		p("// Division by zero");
		model.addSlot("A2", "1/(5-A1)");
		status();
		p("A2: " + (String) model.getSlotString("A2"));
		p("");

		p("// Empty reference");
		model.addSlot("A1","C5");
		status();
		p("A1: " + (String) model.getSlotString("A1"));
		p("");
		
		p("// Incomplete statement");
		model.addSlot("A1","5 *");
		status();

		model.addSlot("A1","5 * i");
		status();
		p("A1: " + (String) model.getSlotString("A1"));
		p("");

		p("// Removing slot leads to error");
		model.addSlot("A1", "");
		status();
		p("A1: " + (String) model.getSlotString("A1"));

		p("\nEnd of program");
	}

	public void status() {
		p("getStatus(): " + model.getStatus());
	}
	public void p(Object o) {
		System.out.println(o);
	}
}