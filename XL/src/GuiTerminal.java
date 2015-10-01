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

		p("// ADD Expression");
		
		model.addSlot("A1", "5");
		model.addSlot("B2", "A1 + 3");
		
		p("// ADD Comment");
		model.addSlot("A2", "#kommentar");

		
		p("// GET (double value)");
		p("A1: " + (double) model.value("A1"));
		p("B2: " + (double) model.value("B2"));
		p("A2: " + (double) model.value("A2"));

		p("// GET String");
		p("A1: " + (String) model.getSlotString("A1"));
		p("B2: " + (String) model.getSlotString("B2"));
		p("A2: " + (String) model.getSlotString("A2"));

		p("// Read empty slot");
		if (model.isEmpty("C1")) {
			p("C1 is empty");
		}
		//Throws exception
			p("C1: " + (double) model.value("C1"));

/*
		p("//Errors");


		p("// Add circular reference");
		status();
		p("// Division by zero");
		status();
		p("// Empty reference");
		status();
		p("Incomplete statement");
		status();*/


		System.out.println("End of program");
	}

	public void status() {
		p("getStatus(): " + model.getStatus());
	}
	public void p(Object o) {
		System.out.println(o);
	}
}