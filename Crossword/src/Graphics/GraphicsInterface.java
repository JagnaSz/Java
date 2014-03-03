package Graphics;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;

import com.itextpdf.awt.PdfGraphics2D;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

import Board.Crossword;
import Browser.CwBrowser;
import Exceptions.CwCreatingException;


public class GraphicsInterface extends JFrame implements ActionListener {

	private SpinnerNumberModel num_height;
	private SpinnerNumberModel num_width;
	private JSpinner height;
	private JSpinner width;
	private JButton generate;
	private JButton get_file;
	private JButton load;
	private JButton print;
	private JButton save;
	private JButton do_cw;
	private JButton next;
	private JButton prev;
	private JTextField path;
	private MyPanel panel1;
	private MyPanel panel2;
	private MyPanel panel3;
	private MyPanel panel4;
	private MainPanel main;
	private JFileChooser open;
	private JFileChooser savefile;
	private JFileChooser loadFromDir;
	private JFileChooser printPDF;
	
	private CwBrowser browser;
	
	/**
	 * Constructor
	 * 
	 * @throws CwCreatingException
	 */
	public GraphicsInterface() throws CwCreatingException{
		setLayout(new FlowLayout());
		setTitle("Generator Krzy¿ówek");
		setSize(1150, 750);
		
		if(browser == null)
			browser = new CwBrowser("out.txt");
		
	
		num_height = new SpinnerNumberModel(5, 5, 15, 1);  
		num_width = new SpinnerNumberModel(5, 5, 15, 1);
		height = new JSpinner(num_height);
		width = new JSpinner(num_width);
		path = new JTextField("out.txt", 15);
		panel1 = new MyPanel("Generuj krzy¿ówkê","Wysokoœæ", height, "Szerokoœæ", width);
		
		get_file = new JButton("...");
		load = new JButton("Wczytaj");
		panel2 = new MyPanel("z pliku",get_file, load, path);
		
		print = new JButton("Drukuj");
		save = new JButton("Zapisz");
		do_cw = new JButton("Rozwi¹¿");
		panel3 = new MyPanel("kontrola", print, save, do_cw);
		
		next = new JButton("Nast.");
		prev = new JButton("Poprz.");
		panel4= new MyPanel("nawigacja", prev, next);
		
		generate.addActionListener(this);
		get_file.addActionListener(this);
		do_cw.addActionListener(this);
		save.addActionListener(this);
		next.addActionListener(this);
		prev.addActionListener(this);
		load.addActionListener(this);
		print.addActionListener(this);
		
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(panel1);
		getContentPane().add(panel2);
		getContentPane().add(panel3);
		getContentPane().add(panel4);
		
		main = new MainPanel();
		add(main);
			
	}
	
	class MyPanel extends JPanel {

        MyPanel(String title, String h, JComponent c, String w, JComponent co) {
            setBorder(new TitledBorder(title));
            add(new JLabel(h));
            add(c);
            add(new JLabel(w));
            add(co);
            generate = new JButton("Generuj!");
            add(generate);
           
        }
        
        MyPanel(String title, JButton b1, JButton b2, JTextField path){
            setBorder(new TitledBorder(title));
            add(path);
            add(b1);
            add(b2);
        }
        
        MyPanel(String title, JButton b1, JButton b2, JButton b3){
            setBorder(new TitledBorder(title));
            add(b1);
            add(b2);
            add(b3);
        }
        
        MyPanel(String title, JButton b1, JButton b2){
        	 setBorder(new TitledBorder(title));
        	 add(b1);
             add(b2);
        }
	}

	class MainPanel extends JPanel{
		Crossword cw;
		boolean solve;
		
		public MainPanel(){
			setPreferredSize(new Dimension(1050,700));
			cw = null;
			solve = false;
		}
		
		/**
		 * Function writes a crossword to pdf
		 * 
		 * @param file  
		 * @param cw
		 * @throws CwCreatingException
		 */
		public  void toPDF(File file, Crossword cw) throws CwCreatingException{
			Document document = null;
			Graphics2D g2 = null;
			try{
			if(cw == null)
				throw new CwCreatingException("Krzyzówka jest pusta!");
			
			document = new Document(PageSize.A4.rotate(), 10, 10, 10, 10);
	    	PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file.getAbsolutePath() +".pdf"));
	        writer.setViewerPreferences(PdfWriter.PageModeUseOC | PdfWriter.FitWindow);
	        writer.setPdfVersion(PdfWriter.VERSION_1_5);
	      
	        document.open(); 
   
	        PdfContentByte canvas = writer.getDirectContent();
	        
	        g2 = new PdfGraphics2D(canvas,PageSize.A4.getHeight(),  PageSize.A4.getWidth());
	        g2.scale(0.85,0.85);
	        canvas.moveTo(0, 50);
	        g2.translate(0,50);
	        this.paint(g2);
	       
			}catch(FileNotFoundException e) {
				throw new CwCreatingException("Nie mo¿na utworzyæ takiego pliku");
			}catch(DocumentException e){
				throw new CwCreatingException("Zapis do pdf nie powiód³ siê");
			}finally{
				if(g2 != null)
					g2.dispose();
				if(document != null)
					document.close();	
			}
		}
		
		/**
		 * Function draws cells and writes clues on frame
		 * 
		 */
		public void paint(Graphics g){
			
			revalidate();
			

			if(cw != null){
			for(int i=0; i < cw.getBoardCopy().getHeight(); i++){
				for(int j=0; j< cw.getBoardCopy().getWidth(); j++) {
					if(cw.getBoardCopy().getCell(j,i).getContent() !="" ){
						if(j==0){
							g.drawString(Integer.toString(i+1) + ". ", 30, 139+30*i);
							g.setColor(Color.blue);
							g.fillRect(49+30*j, 120+30*i, 30, 30);
							g.setColor(Color.black);
							g.drawRect(49+30*j, 120+30*i, 30, 30);
						}
						else{
						g.setColor(Color.black);
						
						g.drawRect(49+30*j, 120+30*i, 30, 30);
						}
					}
					
				}
			}
			int licznik = 0;
			for(int i=0; i < cw.getBoardCopy().getHeight(); i++){
				System.out.println(cw.getBoardCopy().getHeight());
				if((cw.getBoardCopy().getCell(1, i).getContent())!=""){
					g.drawString(i+1 + ". " + cw.getEntries().get(i).getClue(), 450,150+15*licznik);
					licznik++;
				}
			}
			if(solve == true){
				for(int i=0; i< browser.getCwActual().getBoardCopy().getHeight(); i++){
					for(int j=0; j< browser.getCwActual().getBoardCopy().getWidth(); j++) {
						g.drawString(browser.getCwActual().getBoardCopy().getCell(j, i).getContent(), 62+30*j, 139+30*i);
					}
				}
			}
		}	
	}
		
		/**
		 * Function updates crossword
		 * 
		 * @param cw
		 */
		public void update(Crossword cw){
			this.cw = cw;
		}
		
		/**
		 * Function change a status of solving
		 * 
		 */
		public void update_solve(){
			solve = !solve;
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		revalidate();
		repaint();
		
		if(source == get_file) {
			open = new JFileChooser();
			if(open.showDialog(get_file, "Import from file") == JFileChooser.APPROVE_OPTION) {
				File plik = open.getSelectedFile();
				path.setText(plik.getAbsolutePath());
				try {
					browser.setCwDB(path.getText());
				} catch (CwCreatingException e1) {
					this.showErr(e1);
				}
			}
		}	
			else if(source == generate) {
					try {
						browser.generateCw((int)width.getValue(), (int) height.getValue());
					} catch (CwCreatingException e1) {
						this.showErr(e1);
					}
					main.update(browser.getCwActual());	
				}
				
			else if(source == do_cw){
				main.update_solve();
			}
			else if(source == save) {
				savefile = new JFileChooser();
				savefile.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				if (savefile.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
						try{
						browser.writeActual(savefile.getSelectedFile().getPath());
						}catch(CwCreatingException e1){
					this.showErr(e1);
				}
			}
		}
			else if(source == next) {
				browser.next();
				main.update(browser.getCwActual());
				
				
			}
			else if(source == prev) {
				browser.prev();
				main.update(browser.getCwActual());
				
			}
			else if(source == load) {
				
				loadFromDir = new JFileChooser();
				loadFromDir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		        if (loadFromDir.showDialog(load, "Open directory") == JFileChooser.APPROVE_OPTION) {
		             try {
						browser.loadCrosswords(loadFromDir.getSelectedFile().getPath());
						
					} catch (CwCreatingException e1) {
						this.showErr(e1);
					}
		            revalidate();
					repaint();
					main.update(browser.getCwActual()); 
		         }
			}
			else if(source == print) {
				printPDF = new JFileChooser();
		        if (printPDF.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
							try {
								main.toPDF(printPDF.getSelectedFile(), browser.getCwActual());
							} catch (CwCreatingException e1) {
								this.showErr(e1);
							}
		          }
			}
			
				
			
		}
	
	/**
	 * Function shows exceptions in new frame
	 * 
	 * @param exc
	 */
	public void showErr(CwCreatingException exc) {
		ExceptionFrame error = new ExceptionFrame(exc);
		
		error.setVisible(true);
		error.setResizable(false);
		error.setSize(400,170);
		error.setTitle("Error!");
		error.setLocation(420, 300);
		error.setDefaultCloseOperation(EXIT_ON_CLOSE);
		error.revalidate();
		error.repaint();
	}
	
	public static void main(String[] args) throws CwCreatingException {
		
		
		GraphicsInterface frame = new GraphicsInterface();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

 }
		

		
	
	
	

