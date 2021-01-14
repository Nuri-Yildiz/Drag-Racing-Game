import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements KeyListener, ActionListener {
	Timer timer = new Timer(5, this);
	private BufferedImage arac;
	private BufferedImage rakip1;
	private BufferedImage arkaPlan;
	private BufferedImage vitesGostergesi;
	private BufferedImage oyunSonu;
	private int car = 0;
	private int rakip = 0;
	private int hiz;
	private int rakipHiz;
	private BufferedImage baslangicEkrani;
	private BufferedImage bitisCizgisi;

	public Game() {   //oyun constructor'� i�inde kullan�lacak g�rsellerin tan�mlanmas�n�n yap�ld��� k�s�m.

		try {
			arac = ImageIO.read(new FileImageInputStream(new File("sahin.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			rakip1 = ImageIO.read(new FileImageInputStream(new File("Mustang.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			arkaPlan = ImageIO.read(new FileImageInputStream(new File("pist.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			vitesGostergesi = ImageIO.read(new FileImageInputStream(new File("Empty.png")));     //Oyun sonu ve vites g�stergesi ba�ta laz�m olmad��� i�in bo� bir
		} catch (IOException e) {                                                                //png dosyas� tan�mlad�m ba�lang��ta
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			oyunSonu = ImageIO.read(new FileImageInputStream(new File("Empty.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			baslangicEkrani = ImageIO.read(new FileImageInputStream(new File("baslangicEkrani.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			bitisCizgisi = ImageIO.read(new FileImageInputStream(new File("damaliBayrak.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setBackground(Color.BLACK);

	}

	@Override
	public void paint(Graphics arg0) {
		// TODO Auto-generated method stub
		super.paint(arg0);
		arg0.setColor(Color.WHITE);     //t�m g�rsellerin ilk seferinde ekrana �izilmesini sa�layan kodlar.
		arg0.drawImage(arkaPlan, 0, 0, 1920, 420, this);
		arg0.drawImage(vitesGostergesi, car + 20, 425, vitesGostergesi.getHeight() + 30,vitesGostergesi.getWidth() / 100, this);
		arg0.drawImage(bitisCizgisi,1770,120,bitisCizgisi.getHeight()/4,bitisCizgisi.getWidth()/4,this);
		arg0.drawImage(arac, car, 290, arac.getWidth(), arac.getHeight(), this);
		arg0.drawImage(rakip1, rakip, 240, rakip1.getWidth() / 2, rakip1.getHeight() / 2, this);
		arg0.drawImage(oyunSonu,200,130,oyunSonu.getWidth()/2,oyunSonu.getHeight()/2,this);
		arg0.drawImage(baslangicEkrani,0,0,baslangicEkrani.getWidth()/3,baslangicEkrani.getHeight()/3,this);
		arg0.drawString("Aradaki fark= "+ (Math.abs(rakip-car)/28) + "metre" + (Math.abs(rakip-car)%28)*3 + "cm" ,car+20 ,440 );  //1 cm 28 piksel yapt��� i�in
                                                                                                                                //bu bilgiyi baz alarak mesafeyi
		                                                                                                                        //�l�t�m.
	}

	@Override
	public void repaint() {   //ekrana tekrar tekrar �izimleri yapacak olan repaint fonksiyonunun JPanelden override edildi�i k�s�m
		// TODO Auto-generated method stub
		super.repaint();
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		int k = arg0.getKeyCode();
		if(k==KeyEvent.VK_3 && ((rakip >= 1750 || car >= 1750) || (rakip == 0 && car == 0))) {
			try {
				rakip1 = ImageIO.read(new FileImageInputStream(new File("cayman.png")));  //3. zorluk seviyesi i�in farkl� g�r�n�mde bir arac�n tan�mland��� k�s�m.
			} catch (IOException e) {                                                     //keyPressed metodu daha d�zg�n g�r�ns�n diye bu k�s�mda tan�mlad�m.
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(k==KeyEvent.VK_2 && ((rakip >= 1750 || car >= 1750) || (rakip == 0 && car == 0))) {
			try {
				rakip1 = ImageIO.read(new FileImageInputStream(new File("Mustang.png")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(k==KeyEvent.VK_1 && ((rakip >= 1750 || car >= 1750) || (rakip == 0 && car == 0))) {
			try {
				rakip1 = ImageIO.read(new FileImageInputStream(new File("Mustang.png")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {   //ActionListenerdan override etti�im, tu�lar�n bas�ld���n� alg�lamak i�in kulland���m fonksiyon.
		int k = arg0.getKeyCode();
		if (k == KeyEvent.VK_1 && ((rakip >= 1750 || car >= 1750) || (rakip == 0 && car == 0))) {   // Zorluk seviyesine g�re rakibe farkl� ara� modelleri 
			rakipHiz = 3;                                                                           // ve h�z seviyesi verdi�im k�s�m.
		} else if (k == KeyEvent.VK_2 && ((rakip >= 1750 || car >= 1750) || (rakip == 0 && car == 0))) {
			rakipHiz = 4;
		} else if (k == KeyEvent.VK_3 && ((rakip >= 1750 || car >= 1750) || (rakip == 0 && car == 0))) {
			rakipHiz = 5;
		}
		
		
		
		if (k == KeyEvent.VK_ENTER && ((rakip >= 1750 || car >= 1750) || (rakip == 0 && car == 0))) {  //Oyunun ba�lang�c� ve oyun sonu oyuna tekrar
			try {                                                                                                      //ba�lamay� sa�layan if blo�u.
				oyunSonu = ImageIO.read(new FileImageInputStream(new File("Empty.png")));
			} catch (IOException e) {           //oyun sonu ekran�n�n oyun ba�lad�ktan sonra silindi�i k�s�m.(oyun sonu ekran� actionPerformed da tan�mlanm��t�r)
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			hiz = 3;
			car = 0;
			rakip = 0;
			if (k == KeyEvent.VK_1) {          //oyun sonunda tekrar zorluk se�meye imkan sa�layan if blo�u.
				rakipHiz = 3;
			} else if (k == KeyEvent.VK_2) {
				rakipHiz = 4;
			} else if (k == KeyEvent.VK_3) {
				rakipHiz = 5;
			}
			
			if(rakipHiz!=0) {
				timer.start();
			}
			
			try {                             //ba�lang�� ekran�n�n oyun ba�lad�ktan sonra silindi�i k�s�m
				baslangicEkrani = ImageIO.read(new FileImageInputStream(new File("Empty.png")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

			if (car < 160 && car > 100) {    //belirli aral�klarla shift tu�una bas�larak vites artt�rmay� sa�layan if blo�u
				if (k == KeyEvent.VK_SHIFT) {
					hiz = hiz + 1;
				}
			} else if (car < 460 && car > 400) {
				if (k == KeyEvent.VK_SHIFT) {
					hiz = hiz + 1;
				}
			} else if (car < 760 && car > 700) {
				if (k == KeyEvent.VK_SHIFT) {
					hiz = hiz + 1;
				}
			} else if (car < 1060 && car > 1000) {
				if (k == KeyEvent.VK_SHIFT) {
					hiz = hiz + 1;
				}
			} else if (car < 1360 && car > 1300) {
				if (k == KeyEvent.VK_SHIFT) {
					hiz = hiz + 1;
				}
			} else if (car < 1660 && car > 1600) {
				if (k == KeyEvent.VK_SHIFT) {
					hiz = hiz + 1;
				}
			}
			else {
				if (k == KeyEvent.VK_SHIFT) {
					hiz = hiz - 1;
					if(hiz<=0) {
						hiz = 1;
					}
				}
			}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {  //timer'� aktif konuma getirdikten sonra oyunun ilerlemesini sa�layan fonksiyon
		car = car + hiz;
		rakip = rakip + rakipHiz;

		if (car < 160 && car > 100) {
			try {
				vitesGostergesi = ImageIO.read(new FileImageInputStream(new File("download.png")));   //vites artt�r�lan aral�klar� g�rselle�tirmek i�in kulland���m
			} catch (IOException e) {                                                                 //g�rseli �izen if blo�u.
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (car < 460 && car > 400) {
			try {
				vitesGostergesi = ImageIO.read(new FileImageInputStream(new File("download.png")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (car < 760 && car > 700) {
			try {
				vitesGostergesi = ImageIO.read(new FileImageInputStream(new File("download.png")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (car < 1060 && car > 1000) {
			try {
				vitesGostergesi = ImageIO.read(new FileImageInputStream(new File("download.png")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (car < 1360 && car > 1300) {
			try {
				vitesGostergesi = ImageIO.read(new FileImageInputStream(new File("download.png")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (car < 1660 && car > 1600) {
			try {
				vitesGostergesi = ImageIO.read(new FileImageInputStream(new File("download.png")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				vitesGostergesi = ImageIO.read(new FileImageInputStream(new File("Empty.png")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (car >= 1750) {                        //oyun sonu kontrol�n�n yap�ld��� ve kimin kazand���n�n kullan�c�ya g�sterildi�i if blo�u.
			try {
				oyunSonu = ImageIO.read(new FileImageInputStream(new File("kazandiniz.png")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			timer.stop();
		} else if (rakip >= 1750) {
			try {
				oyunSonu = ImageIO.read(new FileImageInputStream(new File("kaybettiniz.png")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			timer.stop();
		}

		repaint();                                       //timer her �al��t���nda �izimi yap�lan g�rselleri tekrar �izen fonksiyon.

	}

}
