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

	public Game() {   //oyun constructor'ý içinde kullanýlacak görsellerin tanýmlanmasýnýn yapýldýðý kýsým.

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
			vitesGostergesi = ImageIO.read(new FileImageInputStream(new File("Empty.png")));     //Oyun sonu ve vites göstergesi baþta lazým olmadýðý için boþ bir
		} catch (IOException e) {                                                                //png dosyasý tanýmladým baþlangýçta
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
		arg0.setColor(Color.WHITE);     //tüm görsellerin ilk seferinde ekrana çizilmesini saðlayan kodlar.
		arg0.drawImage(arkaPlan, 0, 0, 1920, 420, this);
		arg0.drawImage(vitesGostergesi, car + 20, 425, vitesGostergesi.getHeight() + 30,vitesGostergesi.getWidth() / 100, this);
		arg0.drawImage(bitisCizgisi,1770,120,bitisCizgisi.getHeight()/4,bitisCizgisi.getWidth()/4,this);
		arg0.drawImage(arac, car, 290, arac.getWidth(), arac.getHeight(), this);
		arg0.drawImage(rakip1, rakip, 240, rakip1.getWidth() / 2, rakip1.getHeight() / 2, this);
		arg0.drawImage(oyunSonu,200,130,oyunSonu.getWidth()/2,oyunSonu.getHeight()/2,this);
		arg0.drawImage(baslangicEkrani,0,0,baslangicEkrani.getWidth()/3,baslangicEkrani.getHeight()/3,this);
		arg0.drawString("Aradaki fark= "+ (Math.abs(rakip-car)/28) + "metre" + (Math.abs(rakip-car)%28)*3 + "cm" ,car+20 ,440 );  //1 cm 28 piksel yaptýðý için
                                                                                                                                //bu bilgiyi baz alarak mesafeyi
		                                                                                                                        //ölçtüm.
	}

	@Override
	public void repaint() {   //ekrana tekrar tekrar çizimleri yapacak olan repaint fonksiyonunun JPanelden override edildiði kýsým
		// TODO Auto-generated method stub
		super.repaint();
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		int k = arg0.getKeyCode();
		if(k==KeyEvent.VK_3 && ((rakip >= 1750 || car >= 1750) || (rakip == 0 && car == 0))) {
			try {
				rakip1 = ImageIO.read(new FileImageInputStream(new File("cayman.png")));  //3. zorluk seviyesi için farklý görünümde bir aracýn tanýmlandýðý kýsým.
			} catch (IOException e) {                                                     //keyPressed metodu daha düzgün görünsün diye bu kýsýmda tanýmladým.
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
	public void keyPressed(KeyEvent arg0) {   //ActionListenerdan override ettiðim, tuþlarýn basýldýðýný algýlamak için kullandýðým fonksiyon.
		int k = arg0.getKeyCode();
		if (k == KeyEvent.VK_1 && ((rakip >= 1750 || car >= 1750) || (rakip == 0 && car == 0))) {   // Zorluk seviyesine göre rakibe farklý araç modelleri 
			rakipHiz = 3;                                                                           // ve hýz seviyesi verdiðim kýsým.
		} else if (k == KeyEvent.VK_2 && ((rakip >= 1750 || car >= 1750) || (rakip == 0 && car == 0))) {
			rakipHiz = 4;
		} else if (k == KeyEvent.VK_3 && ((rakip >= 1750 || car >= 1750) || (rakip == 0 && car == 0))) {
			rakipHiz = 5;
		}
		
		
		
		if (k == KeyEvent.VK_ENTER && ((rakip >= 1750 || car >= 1750) || (rakip == 0 && car == 0))) {  //Oyunun baþlangýcý ve oyun sonu oyuna tekrar
			try {                                                                                                      //baþlamayý saðlayan if bloðu.
				oyunSonu = ImageIO.read(new FileImageInputStream(new File("Empty.png")));
			} catch (IOException e) {           //oyun sonu ekranýnýn oyun baþladýktan sonra silindiði kýsým.(oyun sonu ekraný actionPerformed da tanýmlanmýþtýr)
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			hiz = 3;
			car = 0;
			rakip = 0;
			if (k == KeyEvent.VK_1) {          //oyun sonunda tekrar zorluk seçmeye imkan saðlayan if bloðu.
				rakipHiz = 3;
			} else if (k == KeyEvent.VK_2) {
				rakipHiz = 4;
			} else if (k == KeyEvent.VK_3) {
				rakipHiz = 5;
			}
			
			if(rakipHiz!=0) {
				timer.start();
			}
			
			try {                             //baþlangýç ekranýnýn oyun baþladýktan sonra silindiði kýsým
				baslangicEkrani = ImageIO.read(new FileImageInputStream(new File("Empty.png")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

			if (car < 160 && car > 100) {    //belirli aralýklarla shift tuþuna basýlarak vites arttýrmayý saðlayan if bloðu
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
	public void actionPerformed(ActionEvent arg0) {  //timer'ý aktif konuma getirdikten sonra oyunun ilerlemesini saðlayan fonksiyon
		car = car + hiz;
		rakip = rakip + rakipHiz;

		if (car < 160 && car > 100) {
			try {
				vitesGostergesi = ImageIO.read(new FileImageInputStream(new File("download.png")));   //vites arttýrýlan aralýklarý görselleþtirmek için kullandýðým
			} catch (IOException e) {                                                                 //görseli çizen if bloðu.
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
		
		if (car >= 1750) {                        //oyun sonu kontrolünün yapýldýðý ve kimin kazandýðýnýn kullanýcýya gösterildiði if bloðu.
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

		repaint();                                       //timer her çalýþtýðýnda çizimi yapýlan görselleri tekrar çizen fonksiyon.

	}

}
