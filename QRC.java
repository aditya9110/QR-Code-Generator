import java.applet.Applet;
import java.awt.Button;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

public class QRC extends Applet implements ActionListener {
	Label l1 = new Label("Welcome to QR Code Generator", Label.CENTER);
	Label l2 = new Label("Enter link or text:");
	Label l3 = new Label("QR Code generated on the desktop");

	Button b = new Button("Generate");

	TextField text = new TextField(50);

	Font myFont1 = new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22);
	Font myFont2 = new Font("Times New Roman", Font.PLAIN, 17);
	Font myFont3 = new Font("Times New Roman", Font.BOLD, 14);

	@Override
	public void init() {
		add(l1);
		l1.setFont(myFont1);
		add(l2);
		l2.setFont(myFont2);
		add(l3);
		l3.setFont(myFont3);
		add(text);
		add(b);
		b.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		try {
			new WriteText();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public class WriteText {
		WriteText() throws IOException {
			String data = text.getText();
			if (data.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter proper infomation!");
				text.requestFocus();
			} else {
				ByteArrayOutputStream b = QRCode.from(data).to(ImageType.JPG).stream();

				File fp = new File("C:\\Users\\Dell\\Desktop\\QRCode.jpg");
				FileOutputStream fos = new FileOutputStream(fp);
				fos.write(b.toByteArray());
				fos.flush();
			}
		}
	}

	@Override
	public void paint(Graphics g) {
		l1.setLocation(520, 14);
		l2.setLocation(520, 60);
		l3.setLocation(520,400);
		text.setLocation(520, 110);
		b.setLocation(670, 160);
		b.setSize(80, 50);

	}
}
