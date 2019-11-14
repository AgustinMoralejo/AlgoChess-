import Fiuba.Excepciones.NoSePuedeCurarEnemigoException;
import Fiuba.Unidad.Curandero;
import Fiuba.Unidad.Jinete;
import Fiuba.Unidad.Soldado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CuranderoTest {

    @Test
    public void testCrearCuranderoTiene75DeVidaYCuesta2Puntos(){

        Curandero curandero = new Curandero();

        Assertions.assertEquals(75, curandero.getPuntosDeVida());
        Assertions.assertEquals(2, curandero.getCosto());
    }


    @Test
    public void testCuranderoRecibe50PuntosDeDanio() {

        Curandero curandero = new Curandero();

        curandero.perderVida(50);
        Assertions.assertEquals(25, curandero.getPuntosDeVida());
    }

    @Test
    public void testCuranderoCuraSoldadoEnRango() {

        Curandero curandero = new Curandero();
        Soldado soldadoACurar = new Soldado();
        curandero.setAlianza("aliado");
        soldadoACurar.setAlianza("aliado");
        curandero.atacar(2, soldadoACurar);
        Assertions.assertEquals(115, soldadoACurar.getPuntosDeVida());
    }

    @Test
    public void testCuranderoCuraJineteEnRango() {

        Curandero curandero = new Curandero();
        Jinete jinete = new Jinete();
        curandero.setAlianza("aliado");
        jinete.setAlianza("aliado");
        curandero.atacar(2, jinete);
        Assertions.assertEquals(115, jinete.getPuntosDeVida());
    }


    @Test
    public void testCuranderoCuraCuranderoEnRango() {

        Curandero curandero = new Curandero();
        Curandero curanderoACurar = new Curandero();
        curandero.setAlianza("aliado");
        curanderoACurar.setAlianza("aliado");
        curandero.atacar(2, curanderoACurar);
        Assertions.assertEquals(90, curanderoACurar.getPuntosDeVida());
    }

    @Test
    public void testCuranderoNoPuedeCurarAUnidadEnemiga(){
        Curandero curandero = new Curandero();
        Jinete jinete = new Jinete();
        curandero.setAlianza("aliado");
        jinete.setAlianza("enemigo");
        Assertions.assertThrows(NoSePuedeCurarEnemigoException.class, () -> curandero.atacar(1, jinete));
    }
}
