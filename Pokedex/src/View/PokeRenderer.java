package View;

import java.awt.*;
import javax.swing.*;

import Model.*;

public class PokeRenderer extends JPanel implements ListCellRenderer {
	private JLabel title;
	private JLabel lblImage;

	public PokeRenderer() {
		this.setOpaque(true);

		this.setLayout(null);

		title = new JLabel();
		title.setBounds(70, 2, 200, 28);
		this.add(title);

		this.lblImage = new JLabel();
		this.lblImage.setBounds(2, 2, 64, 48);
		this.add(lblImage);

		this.setSize(200, 52);
		this.setPreferredSize(new Dimension(200, 52));
	}

	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {

		Pokemon poke = (Pokemon) value;
		title.setText(poke.getName());

		lblImage.setIcon(new ImageIcon("images/pokeball.jpg"));

		if (isSelected) {
			this.setBackground(list.getSelectionBackground());
			this.setForeground(list.getSelectionForeground());
		} else {
			this.setBackground(list.getBackground());
			this.setForeground(list.getForeground());
		}
		return this;
	}
}
