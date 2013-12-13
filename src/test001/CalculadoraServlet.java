package test001;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//Es un servlet controlado por el Spring MVC, sustituto por ejemplo de Struts
@Controller
public class CalculadoraServlet {

 // Aquí está la magia !! Con poner @autowired, spring inyecta automáticamente aquí nuestro bean con el servicio !!
 // No hay que preocuparse de inicializarlo ni gestionarlo ni nada parecido !!
 @Autowired
 private Calculadora servicioCalculadora;
 
 @RequestMapping("calcula.do")
 public void calcula(HttpServletResponse response) throws IOException {
  // Devolvemos la suma gracias al servicio mágico que hemos definido en el applicationContext.xml:)
  response.getOutputStream().println("El resultado de la llamada al servicio es : " + servicioCalculadora.sumar(23, 66));
 }
}
