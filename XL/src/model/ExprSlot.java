package model;

import expr.*;
import java.io.IOException;

/**
 * This <code>Slot<code> handles expressions.
 * @author Emil Westenius, Adam Jalkemo, Anton Friberg, Andrés Þór Sæmundsson. 
 */
public class ExprSlot implements Slot {

	Expr slotExpr;

        public ExprSlot(String slotString) throws IOException {
		
		ExprParser parser = new ExprParser();
        slotExpr = parser.build(slotString);
	}

	public String toString() {
		return slotExpr.toString();
	}

 	public double value(Environment env) {
 		return slotExpr.value(env);
 	}

 }