package javrsim.views;

import javr.core.AVR;
import javax.swing.JFrame;

public abstract class JAvrView extends JFrame {

	public JAvrView(String title) {
		super(title);
	}

	public interface Descriptor {
		/**
		 * Get a useful name for this view.
		 *
		 * @return
		 */
		public String getName();

		/**
		 * Construct a view for a given instrumentable AVR.
		 *
		 * @param avr
		 * @return
		 */
		public JAvrView construct(AVR.Instrumentable avr);
	}
}
