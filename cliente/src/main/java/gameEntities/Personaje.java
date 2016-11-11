package gameEntities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class Personaje {
	Juego juego;

	// Tama�o de la entidad
	private int ancho;
	private int alto;
	
	private float x;
	private float y;
	private float dx;
	private float dy;
	private float xInicio;
	private float yInicio;
	private float xFinal;
	private float yFinal;
	private int xOffset;
	private int yOffset;
	private int drawX;
	private int drawY;
	private int posicionMouse[];
	private int[] tile;

	private float difX;
	private float difY;
	private float relacion;
	
	private float auxX;
	private float auxY;
	
	private boolean enMovimiento;
	private boolean horizontal;
	private boolean vertical;
	private boolean diagonalInfIzq;
	private boolean diagonalInfDer;
	private boolean diagonalSupIzq;
	private boolean diagonalSupDer;

	private LinkedList<BufferedImage[]> animaciones;
	private final Animacion moverIzq;
	private final Animacion moverArribaIzq;
	private final Animacion moverArriba;
	private final Animacion moverArribaDer;
	private final Animacion moverDer;
	private final Animacion moverAbajoDer;
	private final Animacion moverAbajo;
	private final Animacion moverAbajoIzq;

	private Mapa mundo;

	public Personaje(Juego juego, Mapa mapa, int ancho, int alto, float spawnX, float spawnY, LinkedList<BufferedImage[]> animaciones, int velAnimacion) {
		this.juego = juego;
		this.ancho = ancho;
		this.alto = alto;
		this.mundo = mapa;
		xOffset = ancho / 2;
		yOffset = alto / 2;
		x = spawnX;
		y = spawnY;

		this.animaciones = animaciones;

	    moverArriba = new Animacion(velAnimacion, animaciones.get(0));
	    moverArribaDer = new Animacion(velAnimacion, animaciones.get(1));
	    moverDer = new Animacion(velAnimacion, animaciones.get(2));
	    moverAbajoDer = new Animacion(velAnimacion, animaciones.get(3));
	    moverAbajo = new Animacion(velAnimacion, animaciones.get(4));
	    moverAbajoIzq = new Animacion(velAnimacion, animaciones.get(5));
	    moverIzq = new Animacion(velAnimacion, animaciones.get(6));
	    moverArribaIzq = new Animacion(velAnimacion, animaciones.get(7));
	}

	public void actualizar() {
		moverIzq.actualizar();
		moverArribaIzq.actualizar();
		moverArriba.actualizar();
		moverArribaDer.actualizar();
		moverDer.actualizar();
		moverAbajoDer.actualizar();
		moverAbajo.actualizar();
		moverAbajoIzq.actualizar();
		getEntrada();
		mover();
		juego.getCamara().Centrar(this);
	}

	public void getEntrada() {

		posicionMouse = juego.getManejadorDeMouse().obtenerPosicionClick();

		if (juego.getManejadorDeMouse().getNuevoRecorrido()) {
			diagonalInfIzq = false;
			diagonalInfDer = false;
			diagonalSupIzq = false;
			diagonalSupDer = false;
			vertical = false;
			horizontal = false;
			enMovimiento = false;

			xInicio = x;
			yInicio = y;
						
			xFinal = Math.round(posicionMouse[0] + juego.getCamara().getxOffset() - xOffset);
			yFinal = Math.round(posicionMouse[1] + juego.getCamara().getyOffset() - yOffset);
						
			difX = Math.abs(xFinal - xInicio);
			difY = Math.abs(yFinal - yInicio);
			relacion = difX / difY;

			if (difX == 0 || difY == 0) {
				relacion = 1;
			}

			if (difX < ancho && yInicio != yFinal) {
				vertical = true;
				horizontal = true;
			}
			if (difY < alto && xInicio != xFinal) {
				horizontal = true;
				vertical = true;
			}

			if (!vertical && !horizontal) {
				if (xFinal > xInicio && yFinal > yInicio) {
					diagonalInfDer = true;
				} else if (xFinal < xInicio && yFinal > yInicio) {
					diagonalInfIzq = true;
				} else if (xFinal > xInicio && yFinal < yInicio) {
					diagonalSupDer = true;
				} else if (xFinal < xInicio && yFinal < yInicio) {
					diagonalSupIzq = true;
				}
			}

			juego.getManejadorDeMouse().setNuevoRecorrido(false);
			enMovimiento = true;
		}
	}

	public void mover() {

		dx = 0;
		dy = 0;

		if (enMovimiento && (x != xFinal || y != yFinal)) {

			if (vertical) {
				if (yFinal > y) {
					dy++;
				} else {
					dy--;
				}
			}

			if (horizontal) {
				if (xFinal > x) {
					dx++;
				} else {
					dx--;
				}
			}

			if (diagonalInfDer) {
				dx += relacion;
				dy++;
			} else if (diagonalInfIzq) {
				dx -= relacion;
				dy++;
			} else if (diagonalSupDer) {
				dx += relacion;
				dy--;
			} else if (diagonalSupIzq) {
				dx -= relacion;
				dy--;
			}
			
			auxX += dx;
			auxY += dy;
			
			if(horizontal && dx > x || vertical && dy < y || diagonalInfDer || diagonalInfIzq) {
				auxY += 15;
			}
			
			tile = Mapa.mouseATile(auxX, auxY);
			
			if (mundo.getTile((int) tile[0], (int) tile[1]).esObstaculo()) {
				xFinal = x;
				yFinal = y;
				auxX = x;
				auxY= y;
			} else {
				x += dx;
				y += dy;
				auxX = (int) Math.round(x);
				auxY = (int) Math.round(y);
			}

			if (horizontal || vertical) {
				if (auxX == xFinal) {
					horizontal = false;
				}

				if (auxY == yFinal) {
					vertical = false;
				}
			}
	
			if (auxX == xFinal && auxY == yFinal) {
				diagonalInfIzq = false;
				diagonalInfDer = false;
				diagonalSupIzq = false;
				diagonalSupDer = false;
				enMovimiento = false;
			}
		}
	}

	public void graficar(Graphics g) {
		drawX = (int) (x - juego.getCamara().getxOffset());
		drawY = (int) (y - juego.getCamara().getyOffset());
		g.drawImage(getFrameAnimacionActual(), drawX, drawY, ancho, alto, null);
		g.setColor(Color.BLUE);
		g.drawString("Cristian", drawX + 10, drawY - 12);
	}

	private BufferedImage getFrameAnimacionActual() {
		if (horizontal && x > xFinal) {
			return moverIzq.getFrameActual();
		} else if (horizontal && x < xFinal) {
			return moverDer.getFrameActual();
		} else if (vertical && y > yFinal) {
			return moverArriba.getFrameActual();
		} else if (vertical && y < yFinal) {
			return moverAbajo.getFrameActual();
		} else if (diagonalInfIzq) {
			return moverAbajoIzq.getFrameActual();
		} else if (diagonalInfDer) {
			return moverAbajoDer.getFrameActual();
		} else if (diagonalSupIzq) {
			return moverArribaIzq.getFrameActual();
		} else if (diagonalSupDer) {
			return moverArribaDer.getFrameActual();
		}
		
		return moverAbajo.getFrameActual();
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}
	
	public int getxOffset() {
		return xOffset;
	}
	
	public int getYOffset() {
		return yOffset;
	}
}
