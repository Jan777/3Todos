package juego; 
 
import java.awt.image.BufferedImage; 
import java.io.File; 
import java.io.IOException; 
import java.util.LinkedList; 
 
import javax.imageio.ImageIO; 
 
public class Grafico { 
  public static BufferedImage pasto; 
  public static BufferedImage agua; 
  public static BufferedImage vacio; 
  public static BufferedImage arena; 
  public static BufferedImage lava; 
  public static BufferedImage fondo; 
  public static BufferedImage marco; 
     
  public static LinkedList<BufferedImage[]> humano = new LinkedList<>();   
  public static LinkedList<BufferedImage[]> orco = new LinkedList<>();   
  public static LinkedList<BufferedImage[]> elfo = new LinkedList<>();   
   
  public static void cargar() { 
     
    humano = cargarSpritePersonaje(51, 60, 10, "src/main/resources/imagenes/humano.png"); 
    elfo = cargarSpritePersonaje(62, 86, 10, "src/main/resources/imagenes/elfo.png"); 
    orco = cargarSpritePersonaje(66, 95, 10, "src/main/resources/imagenes/orco.png"); 
     
    pasto = cargarSprite("src/main/resources/imagenes/Pasto.png"); 
    agua = cargarSprite("src/main/resources/imagenes/Agua.png"); 
    vacio = cargarSprite("src/main/resources/imagenes/Vacio.png"); 
    arena = cargarSprite("src/main/resources/imagenes/Arena.png"); 
    lava = cargarSprite("src/main/resources/imagenes/LavaConOnda.png"); 
    fondo = cargarSprite("src/main/resources/imagenes/fondo.jpg"); 
    marco = cargarSprite("src/main/resources/imagenes/marco.png"); 
  } 
 
 
  private static BufferedImage cargarSprite(String pathSprite) { 
    try { 
      return ImageIO.read(new File((pathSprite))); 
    } catch (IOException e) { 
      e.printStackTrace(); 
      return null; 
    } 
  } 
 
  private static LinkedList<BufferedImage[]> cargarSpritePersonaje(int ancho, int alto, int cantSpriteLinea, String pathSprite) { 
    BufferedImage sprite = cargarSprite(pathSprite);   
    LinkedList<BufferedImage[]> p = new LinkedList<>(); 
 
    BufferedImage[] lista = new BufferedImage[cantSpriteLinea]; 
    for(int i = 0; i < 8; i++) 
    { 
      lista = new BufferedImage[cantSpriteLinea]; 
      for(int j = 0; j < cantSpriteLinea; j++) 
      { 
        lista[j] = sprite.getSubimage(ancho*j, alto * i, ancho, alto); 
      } 
      p.add(lista); 
    } 
     
     return p; 
  } 
   
}