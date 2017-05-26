import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Image;

public class pokemon extends JFrame{
	
	public pokemon(){
		setSize(900,700);//画面サイズ設定
		setTitle("game");//名前設定
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		MyJPanel myJPanel= new MyJPanel();
		Container c = getContentPane();
		c.add(myJPanel);
		setVisible(true);
		setResizable(false);
		
	}
	
	public static void main(String[] args){
		new pokemon();
	}
	
	public class MyJPanel extends JPanel implements ActionListener, MouseListener{
		
		Timer timer;
		int my_x,my_y;
		int teki_x,teki_y;
		Image image1,image2,image3,image4,image5;
		int stage;
		int green_samashi,green_sabre;
		int bakuha_x,bakuha_y;
		int sec;
		int mouse_x, mouse_y;
		int ball_x,ball_y;
		int ball_vy;
		int samashi_x,samashi_y;
		int a,f;
		
		public MyJPanel(){
			//初期条件の設定
			setBackground(Color.white);	
			addMouseListener(this);
			setFocusable(true);
			setLayout(null);
			
			my_x = 950;
			my_y = 400;
			teki_x=-40;
			teki_y=0;
			stage=1;
			green_samashi=130;
			green_sabre=130;
			bakuha_x=1300;
			bakuha_y=1300;
			ball_x=1300;
			ball_y=1300;
			ball_vy=-3;
			samashi_x=1300;
			samashi_y=1300;
			
			
			
			timer = new Timer(10, this);
			timer.start();//タイマースタート
			
			ImageIcon icon = new ImageIcon("jiki1.jpg");
			image1 = icon.getImage();
			
			ImageIcon icon2 = new ImageIcon("teki1.jpg");
			image2 = icon2.getImage();
			
			ImageIcon icon3 = new ImageIcon("hakaikousen.jpg");
			image3 = icon3.getImage();
			
			ImageIcon icon4 = new ImageIcon("ball.jpg");
			image4 = icon4.getImage();
			
			ImageIcon icon5 = new ImageIcon("samashi.jpg");
			image5 = icon5.getImage();
			
		}
		
		public void paintComponent(Graphics g){
			Dimension d;
			d=getSize();
			super.paintComponent(g);
			
			g.drawImage(image1,my_x,my_y,this);
			g.drawImage(image2,teki_x,teki_y,this);
			g.drawImage(image3,bakuha_x,bakuha_y,this);
			g.drawImage(image4,ball_x,ball_y,this);
			g.drawImage(image5,samashi_x,samashi_y,this);
			
			
			
			if((stage!=1)&&(stage!=2)&&(stage!=-1)&&(stage!=0)&&(stage!=-100)){
				g.setColor(Color.gray);
				g.fillRect(700,300,200,50);
				g.setColor(Color.gray);
				g.fillRect(350,500,200,50);
				g.setColor(Color.black);
				g.setFont(new Font(Font.SERIF,Font.BOLD,20));
				g.drawString("♂さまし　Lv.100",700,300);
				g.setColor(Color.white);
				g.fillRect(730,320,130,10);
				g.setColor(Color.green);
				g.fillRect(730,320,green_samashi,10);
				g.setColor(Color.white);
				g.fillRect(380,520,130,10);
				g.setColor(Color.green);
				g.fillRect(380,520,green_sabre,10);
				g.setColor(Color.black);
				g.setFont(new Font(Font.SERIF,Font.BOLD,20));
				g.drawString("♂サブレ　Lv.100",350,500);
			}
			
			//敵の登場（ステージ１）
			if(stage==1){
				my_x-=3;
				teki_x+=2;
				sec++;
				if(sec>300){
					stage=2;
					sec=0;
				}
			}
			
			//野生の野瀬が現れた（ステージ２）
			if(stage==2){
				g.setColor(Color.black);
				g.fillRect(70,550,730,120);
				g.setColor(Color.white);
				g.fillRect(75,555,720,110);
				g.setColor(Color.black);
				g.setFont(new Font(Font.SERIF,Font.BOLD,30));
				g.drawString("あ、野生の野瀬が飛び出してきた",90,600);
				sec++;
				if(sec>300){
					stage=3;
					sec=0;
				}
			}
			
			//サブレはどうする？、HP表示、たたかう、つかまえる、にげる
			if(stage==3){
				g.setColor(Color.black);
				g.fillRect(70,550,730,120);
				g.setColor(Color.white);
				g.fillRect(75,555,720,110);
				g.setColor(Color.black);
				g.setFont(new Font(Font.SERIF,Font.BOLD,30));
				g.drawString("サブレはどうする？",90,600);
				sec++;
				
				if(sec>200){
				g.setColor(Color.black);
				g.fillRect(660,450,200,220);
				g.setColor(Color.white);
				g.fillRect(665,455,190,210);
				g.setColor(Color.black);
				g.setFont(new Font(Font.SERIF,Font.BOLD,20));
				g.drawString("たたかう",700,500);
				g.setColor(Color.black);
				g.setFont(new Font(Font.SERIF,Font.BOLD,20));
				g.drawString("つかまえる",700,550);
				g.setColor(Color.black);
				g.setFont(new Font(Font.SERIF,Font.BOLD,20));
				g.drawString("愛知に送り返す",700,600);
				}
			}
			
			//たたかう
			if(stage==4){
				g.setColor(Color.black);
				g.fillRect(70,550,430,120);
				g.setColor(Color.white);
				g.fillRect(75,555,420,110);
				g.setColor(Color.black);
				g.setFont(new Font(Font.SERIF,Font.BOLD,25));
				g.drawString("たいあたり",100,600);//41
				g.setColor(Color.black);
				g.setFont(new Font(Font.SERIF,Font.BOLD,25));
				g.drawString("エアスラッシュ",100,650);//42
				g.setColor(Color.black);
				g.setFont(new Font(Font.SERIF,Font.BOLD,25));
				g.drawString("はねやすめ",280,600);//43
				g.setColor(Color.black);
				g.setFont(new Font(Font.SERIF,Font.BOLD,25));
				g.drawString("はかいこうせん",280,650);//44
				
			}
			
			if(stage==5){//つかまえる
				g.setColor(Color.black);
				g.fillRect(70,550,730,120);
				g.setColor(Color.white);
				g.fillRect(75,555,720,110);
				g.setColor(Color.black);
				g.setFont(new Font(Font.SERIF,Font.BOLD,30));
				g.drawString("サブレはモンスターボールを使った",90,600);
				sec++;
				if((sec>150)&&(sec<170)){
					ball_x=70;
					ball_y=550;
				}
				if((sec>170)&&(sec<330)){
					ball_x+=3;
					ball_vy+=0;
					ball_y+=ball_vy;
				}
				if((sec>330)&&(sec<400)){
					teki_x=1300;
					teki_y=1300;
					ball_y+=2;
				}
				if((green_samashi>50)&&(sec>500)&&(sec<700)){
					
				g.setColor(Color.black);
				g.fillRect(70,550,730,120);
				g.setColor(Color.white);
				g.fillRect(75,555,720,110);
				g.setColor(Color.black);
				g.setFont(new Font(Font.SERIF,Font.BOLD,30));
				g.drawString("惜しい、モンスターボールから出てきてしまった",90,600);
					teki_x=560;
					teki_y=0;
					ball_x=1300;
				}
					if((green_samashi<50)&&(sec>500)&&(sec<750)){
					g.setColor(Color.black);
				g.fillRect(70,550,730,120);
				g.setColor(Color.white);
				g.fillRect(75,555,720,110);
				g.setColor(Color.pink);
				g.setFont(new Font(Font.SERIF,Font.BOLD,30));
						g.drawString("おめでとう！サブレはさましをゲットした",90,600);
					
				}
				if((green_samashi>50)&&(sec>750)){
					stage=3;
					sec=0;
				}
				if((green_samashi<50)&&(sec>750)){
					stage=-100;
				}
			}
			
			if(stage==6){//にげる
				g.setColor(Color.black);
				g.fillRect(70,550,730,120);
				g.setColor(Color.white);
				g.fillRect(75,555,720,110);
				g.setColor(Color.black);
				g.setFont(new Font(Font.SERIF,Font.BOLD,30));
				g.drawString("さましは愛知に帰って行った",90,600);
				
				sec++;
				if(sec>200){
					teki_x=1300;
					stage=-100;
					sec=0;
			}
			}
			
			if(stage==41){//たいあたり
				g.setColor(Color.black);
				g.fillRect(70,550,730,120);
				g.setColor(Color.white);
				g.fillRect(75,555,720,110);
				g.setColor(Color.black);
				g.setFont(new Font(Font.SERIF,Font.BOLD,30));
				g.drawString("サブレのたいあたり",90,600);
				sec++;
				if((sec>200)&&(sec<250)){
					my_x+=1;
					my_y-=1;
				}
				if((sec>250)&&(sec<300)){
					my_x-=1;
					my_y+=1;
				}
				if((sec>300)&&(sec<320)){
					green_samashi-=1;
				}
				if(sec>400){
					stage=100;
					sec=0;
				}
			}
			
			if(stage==42){//エアスラッシュ
				g.setColor(Color.black);
				g.fillRect(70,550,730,120);
				g.setColor(Color.white);
				g.fillRect(75,555,720,110);
				g.setColor(Color.black);
				g.setFont(new Font(Font.SERIF,Font.BOLD,30));
				g.drawString("サブレのエアスラッシュ",90,600);
				sec++;
				if((sec>200)&&(sec<300)){
					my_x+=10;
					my_y-=10;
				}
				if((sec>300)&&(sec<340)){
					my_x=30;
					my_y=400;
					green_samashi-=1;
				}
				if(sec>450){
					stage=100;
					sec=0;
				}
			}
			
			if(stage==43){//はねやすめ
				g.setColor(Color.black);
				g.fillRect(70,550,730,120);
				g.setColor(Color.white);
				g.fillRect(75,555,720,110);
				g.setColor(Color.black);
				g.setFont(new Font(Font.SERIF,Font.BOLD,30));
				g.drawString("サブレのはねやすめ",90,600);
				sec++;
				if((green_sabre<130)&&(sec>200)&&(sec<250)){
					green_sabre+=1;
				}
				if(sec>300){
					stage=100;
					sec=0;
				}
			}
			
			if(stage==44){//はかいこうせん
				g.setColor(Color.black);
				g.fillRect(70,550,730,120);
				g.setColor(Color.white);
				g.fillRect(75,555,720,110);
				g.setColor(Color.black);
				g.setFont(new Font(Font.SERIF,Font.BOLD,30));
				g.drawString("サブレのはかいこうせん",90,600);
				sec++;
				if((sec>200)&&(sec<250)){
					bakuha_x=70;
					bakuha_y=550;
				}
				if((sec>250)&&(sec<350)){
					bakuha_x+=5;
					bakuha_y-=5;
				}
				if((sec>450)&&(sec<500)){
					bakuha_x=1300;
					bakuha_y=550;
					green_samashi-=1;
				}
				if(sec>600){
					stage=100;;
					sec=0;
				}
			}
			
			if(stage==100){//さましの攻撃
				a=(int)(Math.random()*100);
				f=a%4;
				stage=101;
			}
			
			if(stage==101){
				if(f==0){
				g.setColor(Color.black);
				g.fillRect(70,550,730,120);
				g.setColor(Color.white);
				g.fillRect(75,555,720,110);
				g.setColor(Color.black);
				g.setFont(new Font(Font.SERIF,Font.BOLD,30));
				g.drawString("さましのじたばた",90,600);
				sec++;
				
				if((sec>200)&&(sec<210)){
					teki_x+=2;
				}
				if((sec>210)&&(sec<220)){
					teki_x-=2;
				}
				if((sec>220)&&(sec<230)){
					teki_x+=2;
				}
				if((sec>230)&&(sec<240)){
					teki_x-=2;
				}
				if((sec>300)&&(sec<330)){
					green_sabre-=1;
				}
				if(sec>400){
					stage=3;
					sec=0;
					}
				}
				
				if(f==1){
				g.setColor(Color.black);
				g.fillRect(70,550,730,120);
				g.setColor(Color.white);
				g.fillRect(75,555,720,110);
				g.setColor(Color.black);
				g.setFont(new Font(Font.SERIF,Font.BOLD,30));
				g.drawString("さましの自己再生",90,600);
				sec++;
				
				if((green_samashi<130)&&(sec>200)&&(sec<250)){
					green_samashi+=1;
				}
				if(sec>300){
					stage=3;
					sec=0;
				}
				}
				
				if(f==2){
				g.setColor(Color.black);
				g.fillRect(70,550,730,120);
				g.setColor(Color.white);
				g.fillRect(75,555,720,110);
				g.setColor(Color.black);
				g.setFont(new Font(Font.SERIF,Font.BOLD,30));
				g.drawString("さましのとっしん",90,600);
				sec++;
				
				if((sec>200)&&(sec<300)){
						teki_x-=3;
						teki_y+=3;
				}
				if((sec>300)&&(sec<330)){
						teki_x=560;
						teki_y=0;
						green_sabre-=2;
						green_samashi-=1;
				}
				if(sec>400){
					stage=3;
					sec=0;
					}
				}
				
				if(f==3){
				g.setColor(Color.black);
				g.fillRect(70,550,730,120);
				g.setColor(Color.white);
				g.fillRect(75,555,720,110);
				g.setColor(Color.black);
				g.setFont(new Font(Font.SERIF,Font.BOLD,30));
				g.drawString("さましのはねる",90,600);
				sec++;
				
				if((sec>200)&&(sec<210)){
					teki_y+=2;
				}
				if((sec>210)&&(sec<220)){
					teki_y-=2;
				}
				if((sec>220)&&(sec<230)){
					teki_y+=2;
				}
				if((sec>230)&&(sec<240)){
					teki_y-=2;
				}
				if((sec>300)&&(sec<330)){
					green_sabre-=0;
				}
				if(sec>400){
					stage=3;
					sec=0;
					}
				}
				
			}
			
			if(stage==0){//自滅
				g.setColor(Color.black);
				g.fillRect(70,550,730,120);
				g.setColor(Color.white);
				g.fillRect(75,555,720,110);
				g.setColor(Color.black);
				g.setFont(new Font(Font.SERIF,Font.BOLD,30));
				g.drawString("サブレは倒れた",90,600);
				my_x=1300;
				my_y=1300;
			}
			
			if(stage==-1){//勝利
				g.setColor(Color.black);
				g.fillRect(70,550,730,120);
				g.setColor(Color.white);
				g.fillRect(75,555,720,110);
				g.setColor(Color.black);
				g.setFont(new Font(Font.SERIF,Font.BOLD,30));
				g.drawString("さましは倒れた",90,600);
				teki_x=1300;
				teki_y=1300;
			}
			
			if(stage==-100){
				my_x=1300;
				samashi_x=50;
				samashi_y=50;
				sec++;
				if(sec>300){
				g.setColor(Color.black);
				g.fillRect(550,200,300,450);
				g.setColor(Color.white);
				g.fillRect(555,205,290,440);
				g.setColor(Color.black);
				g.setFont(new Font(Font.SERIF,Font.BOLD,30));
				g.drawString("さまし",570,250);
				g.setColor(Color.black);
				g.setFont(new Font(Font.SERIF,Font.BOLD,30));
				g.drawString("生息地：愛知",570,300);
				}
			}
			
		}
		public void actionPerformed(ActionEvent e){
			
			if(green_sabre<0){
				stage=0;
			}
			
			if(green_samashi<0){
				stage=-1;
			}
			
					//System.exit(0);//終了
				repaint();//必須
			//System.exit(0);//自分の勝ち
		}
		
	   
		public void mousePressed(MouseEvent me)
		{
			mouse_x = me.getX();
			mouse_y = me.getY();
			if((stage==3)&&(700<mouse_x)&&(mouse_x<800)&&(470<mouse_y)&&(mouse_y<500)){
				stage = 4;//たたかう条件
				sec=0;
			}else if((stage==3)&&(700<mouse_x)&&(mouse_x<800)&&(520<mouse_y)&&(mouse_y<550)){
				stage = 5;//つかまえる条件
				sec=0;
			}else if((stage==3)&&(700<mouse_x)&&(mouse_x<800)&&(570<mouse_y)&&(mouse_y<600)){
				stage = 6;//にげる条件
				sec=0;
			}else if((stage==4)&&(70<mouse_x)&&(mouse_x<270)&&(550<mouse_y)&&(mouse_y<620)){
				stage = 41;//たいあたり
				sec=0;
			}else if((stage==4)&&(70<mouse_x)&&(mouse_x<270)&&(600<mouse_y)&&(mouse_y<700)){
				stage = 42;//エアスラッシュ
				sec=0;
			}else if((stage==4)&&(270<mouse_x)&&(mouse_x<450)&&(550<mouse_y)&&(mouse_y<620)){
				stage = 43;//はねやすめ
				sec=0;
			}else if((stage==4)&&(270<mouse_x)&&(mouse_x<450)&&(600<mouse_y)&&(mouse_y<700)){
				stage = 44;//はかいこうせん
				sec=0;
			}else{
				stage=3;
				sec=0;
			}
			repaint();
		}
		
		public void mouseClicked(MouseEvent me)
		{
		}		
		public void mouseReleased(MouseEvent me)
		{
		}		
		public void mouseExited(MouseEvent me)
		{
		}		
		public void mouseEntered(MouseEvent me)
		{
		}		
		public void mouseMoved(MouseEvent me)
		{
		}		
		public void mouseDragged(MouseEvent me)
		{
		}	
	}
}
