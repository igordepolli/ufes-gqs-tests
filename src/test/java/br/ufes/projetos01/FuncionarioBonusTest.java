package br.ufes.projetos01;

import br.ufes.calculodebonus.ProcessadoraBonus;
import br.ufes.model.Funcionario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 *
 * @author clayton
 *
 *         Link planilha corrigido:
 *         https://docs.google.com/spreadsheets/d/1FMJI94S7AXbL6DljBDSp-IqxbR7ehjqAhkg0HHXrF10/edit?usp=sharing
 *
 */
public class FuncionarioBonusTest {

  public FuncionarioBonusTest() {
  }

  @BeforeClass
  public static void setUpClass() {
  }

  @AfterClass
  public static void tearDownClass() {
  }

  @Before
  public void setUp() {

  }

  @After
  public void tearDown() {
  }

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void CT001() throws Exception {
    // Arrange
    Funcionario funcionario = new Funcionario("Fulano", 2500.00, "Gerente");
    double salarioEsperado = 2500.00;

    // Assert
    assertEquals(salarioEsperado, funcionario.getSalarioBase(), 0.001);
  }

  @Test
  public void CT002() throws Exception {
    // Arrange
    Funcionario funcionario = new Funcionario("Fulano", 2500.00, "Gerente");
    funcionario.setFaltas(2);
    double salarioEsperado = 2650.00;
    ProcessadoraBonus pb = new ProcessadoraBonus();

    // Act
    pb.processar(funcionario);
    
    // Assert
    assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
  }

  @Test
  public void CT003() throws Exception {
    // Arrange
    Funcionario funcionario = new Funcionario("Fulano", 2500.00, "Gerente");
    funcionario.setFaltas(2);
    funcionario.setDistanciaMoradia(101);
    ProcessadoraBonus pb = new ProcessadoraBonus();
    double salarioEsperado = 2950.00;

    // Act
    pb.processar(funcionario);

    // Assert
    assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
  }

  @Test
  public void CT004() throws Exception {
    // Arrange
    Funcionario funcionario = new Funcionario("Fulano", 2500.00, "Gerente");
    funcionario.setFaltas(2);
    funcionario.setDistanciaMoradia(151);
    ProcessadoraBonus pb = new ProcessadoraBonus();
    double salarioEsperado = 3150.00;

    // Act
    pb.processar(funcionario);

    // Assert
    assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
  }

  @Test
  public void CT005() throws Exception {
    // Arrange
    Funcionario funcionario = new Funcionario("Fulano", 2500.00, "Gerente");
    funcionario.setFaltas(2);
    funcionario.setDistanciaMoradia(51);
    ProcessadoraBonus pb = new ProcessadoraBonus();
    double salarioEsperado = 2800.00;

    // Act
    pb.processar(funcionario);

    // Assert
    assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
  }

  @Test
  public void CT006() throws Exception {
    // Arrange
    Funcionario funcionario = new Funcionario("Fulano", 998.0, "Gerente");

    // Assert
    assertEquals(998, funcionario.getSalario(), 0.001);
  }

  @Test
  public void CT007() throws Exception {
    // Arrange
    thrown.expect(Exception.class);
    thrown.expectMessage(is("\n#1 Informe um nome v??lido"));

    // Assert
    new Funcionario(null, 2500.00, "Gerente");
  }

  @Test
  public void CT008() throws Exception {
    // Arrange
    thrown.expect(Exception.class);
    thrown.expectMessage(is("\n#1 Informe um nome v??lido"));

    // Assert
    new Funcionario("", 2500.00, "Gerente");
  }

  @Test
  public void CT009() throws Exception {
    // Arrange
    thrown.expect(Exception.class);
    thrown.expectMessage(is("\n#2 Informe um cargo v??lido"));

    // Assert
    new Funcionario("Fulano", 2500.00, null);
  }

  @Test
  public void CT010() throws Exception {
    // Arrange
    thrown.expect(Exception.class);
    thrown.expectMessage(is("\n#2 Informe um cargo v??lido"));

    // Assert
    new Funcionario("Fulano", 2500.00, "");
  }

  @Test
  public void CT011() throws Exception {
    // Arrange
    Funcionario funcionario = new Funcionario("Fulano", 2500.00, "SUPERVISOR");

    double salarioEsperado = 2705.00;

    ProcessadoraBonus pb = new ProcessadoraBonus();

    // Act
    pb.processar(funcionario);

    // Assert
    assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
  }

  @Test
  public void CT012() throws Exception {
    // Arrange
    Funcionario funcionario = new Funcionario("Fulano", 2500.00, "SUPERVISOR");
    funcionario.setDistanciaMoradia(10);

    double salarioEsperado = 2705.00;

    ProcessadoraBonus pb = new ProcessadoraBonus();

    // Act
    pb.processar(funcionario);

    // Assert
    assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
  }

  @Test
  public void CT013() throws Exception {
    // Arrange
    Funcionario funcionario = new Funcionario("Fulano", 2500.00, "SUPERVISOR");
    funcionario.setDistanciaMoradia(100);

    double salarioEsperado = 2855.00;

    ProcessadoraBonus pb = new ProcessadoraBonus();

    // Act
    pb.processar(funcionario);

    // Assert
    assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
  }

  @Test
  public void CT014() throws Exception {
    // Arrange
    Funcionario funcionario = new Funcionario("Fulano", 2500.00, "PROGRAMADOR");

    double salarioEsperado = 2675.00;

    ProcessadoraBonus pb = new ProcessadoraBonus();

    // Act
    pb.processar(funcionario);

    // Assert
    assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
  }

  @Test
  public void CT015() throws Exception {
    // Arrange
    Funcionario funcionario = new Funcionario("Fulano", 2500.00, "PROGRAMADOR");
    funcionario.setDistanciaMoradia(10);
    funcionario.setFaltas(6);

    double salarioEsperado = 2575.00;

    ProcessadoraBonus pb = new ProcessadoraBonus();

    // Act
    pb.processar(funcionario);

    // Assert
    assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
  }

  @Test
  public void CT016() throws Exception {
    // Arrange
    thrown.expect(Exception.class);
    thrown.expectMessage(is("Dist??ncia n??o pode ser menor que zero!"));
    Funcionario funcionario = new Funcionario("Fulano", 2500.00, "PROGRAMADOR");

    // Assert
    funcionario.setDistanciaMoradia(-1);
  }

  @Test
  public void CT017() throws Exception {
    // Arrange
    thrown.expect(Exception.class);
    thrown.expectMessage(is("Faltas n??o pode ser menor que zero!"));
    Funcionario funcionario = new Funcionario("Fulano", 2500.00, "PROGRAMADOR");

    // Assert
    funcionario.setFaltas(-1);
  }

  @Test
  public void CT018() throws Exception {
    // Arrange
    thrown.expect(Exception.class);
    thrown.expectMessage(is("\n#3 O sal??rio base deve ser >= R$ 998,00"));

    // Assert
    new Funcionario("Fulano", 0.00, "Gerente");
  }
  
  @Test
  public void CT019() throws Exception {
    // Arrange
    thrown.expect(Exception.class);
    thrown.expectMessage(is("\n#2 Informe um cargo v??lido"));

    // Assert
    Funcionario funcionario = new Funcionario("Fulano", 998.00, "Qualquer");
  }
  
  @Test
  public void CT020() throws Exception {
    // Arrange
    Funcionario funcionario = new Funcionario("Fulano", 998.00, "Supervisor Senior");

    double salarioEsperado = 1127.9;

    ProcessadoraBonus pb = new ProcessadoraBonus();

    // Act
    pb.processar(funcionario);

    // Assert
    assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
  }
  
 
  @Test
  public void CT021() throws Exception {
    // Arrange
    Funcionario funcionario = new Funcionario("Fulano", 998.00, "Gerente");
    thrown.expect(Exception.class);
    thrown.expectMessage(is("\n#1 Informe um nome v??lido"));

    // Assert
    funcionario.setNome(null);
  }
  
    @Test
  public void CT022() throws Exception {
    // Arrange
    Funcionario funcionario = new Funcionario("Fulano", 998.00, "Gerente");
    thrown.expect(Exception.class);
    thrown.expectMessage(is("\n#1 Informe um nome v??lido"));

    // Assert
    funcionario.setNome("");
  }
  
  
  @Test
  public void CT023() throws Exception {
    // Arrange
    Funcionario funcionario = new Funcionario("Fulano", 998.00, "Gerente");
    thrown.expect(Exception.class);
    thrown.expectMessage(is("\n#2 Informe um cargo v??lido"));

    // Assert
    funcionario.setCargo(null);
  }
  
    @Test
  public void CT024() throws Exception {
    // Arrange
    Funcionario funcionario = new Funcionario("Fulano", 998.00, "Gerente");
    thrown.expect(Exception.class);
    thrown.expectMessage(is("\n#2 Informe um cargo v??lido"));

    // Assert
    funcionario.setCargo("");
  }
   
  @Test
  public void CT025() throws Exception {
    // Arrange
    Funcionario funcionario = new Funcionario("Fulano", 998.00, "Gerente");
    double salarioEsperado = 1147.9;
    ProcessadoraBonus pb = new ProcessadoraBonus();

    // Act
    pb.processar(funcionario);
    pb.processar(funcionario);

    // Assert
    assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
  }
  
  


}
