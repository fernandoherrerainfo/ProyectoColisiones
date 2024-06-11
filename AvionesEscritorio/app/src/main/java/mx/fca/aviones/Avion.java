package mx.fca.aviones;

public class Avion {
   //cambio parcial
   private Direccion direccion;
    private int x;
    private int y;

    public Avion(Direccion direccion, int x, int y) {
        this.direccion = direccion;
        this.x = x;
        this.y = y;
    }

    public void mover() {
        switch (direccion) {
            case NORTH:
                y--;
                break;
            case SOUTH:
                y++;
                break;
            case EAST:
                x++;
                break;
            case WEST:
                x--;
                break;
        }
    }

    public boolean colisionaCon(Avion otro) {

        return this.x == otro.x && this.y == otro.y;
    }

    public int getImage() {
        switch (direccion){
            case NORTH:
                return R.mipmap.north;
            case SOUTH:
                return R.mipmap.south;
            case EAST:
                return R.mipmap.east;
            case WEST:
                return R.mipmap.west;
        }
        return R.mipmap.north;
    }

    // Getters y setters
    public Direccion getDireccion() {

        return direccion;
    }
    public void setDireccion(Direccion direccion) {

        this.direccion = direccion;
    }

    public int getX() {

        return x;
    }

    public void setX(int x) {

        this.x = x;
    }

    public int getY() {

        return y;
    }

    public void setY(int y) {

        this.y = y;
    }
}
