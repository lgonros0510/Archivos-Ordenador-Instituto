
package coche;

import junit.framework.TestCase;

/**
 *
 * Test de Pruebas JUnit para la Clase Coche 
 */
public class CocheTest extends TestCase {
    
    public CocheTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    
    /**
     * Test para el método Comprar. Si el método comprar es correcto la prueba debe ser exitosa
     */
    
    public void testComprar1() throws Exception {
        System.out.println("Test de prueba para Comprar");
        int cantidad = 100;
        Coche coche1 = new Coche("Ford",12000,300);
        coche1.comprar(cantidad);
        assertTrue(coche1.obtenerStock()==400); /* Como parto de un stock de 300 al comprar 100 
         * coches más ahora el stock es de 400  */
        
    }

    
       /**
     * Test para el método Comprar. Esta prueba debe ser fallida porque intento comprar una 
     * cantidad negativa de coches
     */
    
    public void testComprar2() throws Exception {
        System.out.println("Test de prueba para Comprar");
        int cantidad = -100;
        Coche coche1 = new Coche("Ford",12000,300);
        coche1.comprar(cantidad);
        assertTrue(coche1.obtenerStock()==200);  
    }
    
   
    /**
     * Test para el método Vender. Si el método vender es correcto la prueba debe ser exitosa
     */
    public void testVender1() throws Exception {
        System.out.println("vender");
        int cantidad = 200;
        Coche coche1 = new Coche("Ford",12000,300);
        coche1.vender(cantidad);
        assertTrue(coche1.obtenerStock()==100); /* Como parto de un stock de 300 al comprar 100 
         * coches más ahora el stock es de 400  */
    }
       
      /**
     * Test para el método Vender. Esta prueba debe ser fallida porque intento vender más coches 
     *  que hay en stock
     */    
        
   public void testVender2() throws Exception {
        System.out.println("vender");
        int cantidad = 400;
        Coche coche1 = new Coche("Ford",12000,300);
        coche1.vender(cantidad);
        assertTrue(coche1.obtenerStock()==-100);  
         
   }    
        
      /**
     * Test para el método Vender. Esta prueba debe ser fallida porque intento vender una 
     * cantidad negativa de coches
     */
   
   
    public void testVender3() throws Exception {
        System.out.println("vender");
        int cantidad = -200;
        Coche coche1 = new Coche("Ford",12000,300);
        coche1.vender(cantidad);
        assertTrue(coche1.obtenerStock()==100);   
            
    }
}
