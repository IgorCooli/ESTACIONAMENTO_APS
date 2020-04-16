/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estacionamento_aps;

import controller.AtribuiLog;
import controller.ClienteController;
import controller.EstacionamentoController;
import controller.MovimentacaoController;
import controller.PagamentoController;
import controller.VagaController;
import controller.VeiculoController;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import model.LogSingleton;
import model.Vaga;

/**
 *
 * @author coliv
 */
public class Estacionamento_APS {

    public static void main(String[] args) {
    
                
        Scanner tc = new Scanner(System.in);
        
        AtribuiLog atribuiLog = new AtribuiLog();             
        
        ClienteController cc = new ClienteController();
        VeiculoController vc = new VeiculoController();
        MovimentacaoController mc = new MovimentacaoController();
        EstacionamentoController ec = new EstacionamentoController();
        
        ArrayList<PagamentoController> pagamentos = new ArrayList<>();
        ArrayList<ClienteController> clientes = new ArrayList<>();
        
        // Capacidade máxima do estacionamento é 500.
        int capacidade = 20;
        
        
        for(int i = 0; i < capacidade; i++){
            VagaController vaga = new VagaController();
            vaga.setNumero(i + 1);
            vaga.setDisponivel(true);            
            ec.addVaga(vaga.getModel());
        }
        
        // Classe que executa a formatação:
        SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        
        boolean appOn = true;
        int opcaoEscolhida;
        
        while(appOn == true){
            
            // Print MENU Estacionamento
            ec.getView().printMenuEstacionamento();
            
            opcaoEscolhida = tc.nextInt();
            System.out.println();
            
            switch(opcaoEscolhida){
                
                case 1:
                   // ENTRADA DE VEÍCULOS
                   try{
                        ClienteController clienteCadastro = new ClienteController();
                        VeiculoController vCadastro = new VeiculoController();
                        VagaController vagaCadastro = new VagaController();
                        
                        for(Vaga vaga : ec.getVagas()){
                            VagaController vagaCont = new VagaController();
                            vagaCont.setModel(vaga);
                            vagaCont.getView().printVaga(vaga.getNumero(), vaga.isDisponivel());
                        }
                        
                        vc.getView().cadastrarVeiculo();
                        vc.getView().inputPlaca();
                        vCadastro.setPlaca(tc.next());
                        tc.nextLine();
                        vc.getView().inputModelo();
                        vCadastro.setModelo(tc.next());
                        tc.nextLine();
                        vc.getView().inputCor();
                        vCadastro.setCor(tc.next());
                        tc.nextLine(); 
                        try {
                             // String horaEntrada = tc.nextLine();
                              Date dtEntrada = new Date();
                              formata.format(dtEntrada);
                              vCadastro.getMovimentacao().setDataEntrada(dtEntrada);      
                                mc.getView().horarioEntrada();
                               System.out.println(formata.format(vCadastro.getMovimentacao().getDataEntrada()));
                        } catch (Exception e) {
                               System.out.println("Horário Invalido");
                               System.out.println("O cadastro não pode ser concluído! Tente Novamente!");                               
                        }
                        
                        //Cadastro de Cliente
                        cc.getView().cadastrarCliente();
                        cc.getView().inputNome();
                        clienteCadastro.setNome(tc.next());
                        tc.nextLine();
                        cc.getView().inputEndereco();
                        clienteCadastro.setEndereco(tc.next());
                        tc.nextLine();
                        cc.getView().inputTelefone();
                        clienteCadastro.setTelefone(tc.next());
                        tc.nextLine();
                        clienteCadastro.setVeiculo(vCadastro.getModel());
                        
                        // Entrada de dados para inserir o número da vaga.
                        System.out.println("Numero da vaga estacionada?");
                        int numeroVaga = tc.nextInt();
                        
                        // Variável de controle para informar se a vaga tá disponível ou não.
                        boolean controleDisponibilidade = false;
                        
                        // Método para verificar se a vaga já está ocupada.
                        // Percorre a lista de vagas ocupadas para ver se já tem um número de vaga de acordo com o informado.
                        
                        
                        for(Vaga vaga : ec.getVagas()){
                            if(numeroVaga == vaga.getNumero() && vaga.isDisponivel() == false){
                                System.out.println("A vaga de número:" + numeroVaga +" encontra-se ocupada. Escolha outra vaga!");
                            }
                            else if(numeroVaga == vaga.getNumero() && vaga.isDisponivel() == true){
                                controleDisponibilidade = true;
                                vagaCadastro.setModel(vaga);
                            }
                         }                       
                        
                        // Caso a vaga não esteja ocupada é feito o cadastro.
                        if(controleDisponibilidade == true){
                            Boolean disponivel = false;
                            
                            
                            // CONTINUAR AMANHÃ DAQUI.
                            vagaCadastro.setVeiculo(vCadastro.getModel());                            
                            vagaCadastro.setDisponivel(disponivel);                                                                                    
                            clientes.add(clienteCadastro);
                            atribuiLog.executaLog(vCadastro);
                           
                        }
                        else
                            ec.getView().falhaCadastro();
                   }
                   catch (Exception e) {
                       System.out.println("Erro ao cadastrar veículo.");
                   }
                   
                   break;
                   
                case 2:
                    // LISTAR VEICULOS ESTACIONADOS
                    vc.getView().listarVeiculos();
                    
                    for(Vaga vagas : ec.getVagas()){
                        
                        VagaController vaga = new VagaController();
                        VeiculoController veiculo = new VeiculoController();
                        
                        vaga.setModel(vagas);
                        if(!vaga.getDisponivel())  {
                            vaga.getView().printVaga(vaga.getNumero(), vaga.getDisponivel());
                            veiculo.setModel(vaga.getVeiculo());
                            veiculo.getView().printVeiculo(veiculo.getPlaca(), veiculo.getModelo(), veiculo.getCor());
                            System.out.println(formata.format(veiculo.getMovimentacao().getDataEntrada()));
                            System.out.println();     
                        }            
                        
                        
                    }
                    /*
                    for(VagaController vaga : vagasOcupadas){
                        vaga.getView().printVaga(vaga.getNumero(), false);                        
                    }
                    System.out.println();
                    System.out.println("VAGAS DISPONÍVEIS:" + capacidade);
                    System.out.println();   */                  
                    break;
                    
                case 3:
                    // SAÍDA DE VEÍCULOS
                    // TODO: usar o atribuiLog para adicionar o carro na lista do log
                    try {                        
                        
                        ec.getView().saidaVeiculo();
                        String plVeiculoSaida = tc.next();
                        VeiculoController veiculoSaida = new VeiculoController();
                        PagamentoController pagamentoSaidaVeiculo = new PagamentoController();
                        ClienteController clienteSaida = new ClienteController();
                        VagaController vaga = new VagaController();
                        
                        // VARIÁVEL PARA ARMAZENAR A DATA DE ENTRADA DO VEÍCULO QUE ESTÁ SAINDO.
                        // NÃO ENCONTREI OUTRA FORMA DE FAZER ISTO.
                        Date dataEntrada = null;
                                                
                        Boolean controleSaidaCarro = false;
                        
                        for(ClienteController cliente : clientes){
                            if(plVeiculoSaida.equals(cliente.getVeiculo().getPlaca())){
                                 controleSaidaCarro = true;
                                 dataEntrada = cliente.getVeiculo().getMovimentacao().getDataEntrada();
                                 clienteSaida.setModel(cliente.getModel()); 
                                System.out.println("Veículo encontrado!");
                                System.out.println();                                
                            }                            
                        }
                        
                        if (controleSaidaCarro == true) {                            
                                                        
                            Date saida = new Date();
                            formata.format(saida);  
                            // Setando a hora de saída do cliente
                            clienteSaida.getVeiculo().getMovimentacao().setDataSaida(saida);
                            pagamentoSaidaVeiculo.setData(saida);
                            
                            System.out.println(formata.format(clienteSaida.getVeiculo().getMovimentacao().getDataSaida()));
                            
                            pagamentoSaidaVeiculo.setCliente(clienteSaida.getModel());
                            
                            //TRANSFORMAR OS MILISEGUNDOS EM SEGUNDOS
                            double diffSeconds = (pagamentoSaidaVeiculo.getDateDiff(dataEntrada,clienteSaida.getVeiculo().getMovimentacao().getDataSaida(), TimeUnit.SECONDS)/1000);                            
                                                        
                            // Altera o valor do pagamento e Cálculo de Pagamento.
                            pagamentoSaidaVeiculo.setValor(pagamentoSaidaVeiculo.calculaValorPagamento(diffSeconds));
                            
                            pagamentoSaidaVeiculo.getView().printPagamento(pagamentoSaidaVeiculo.getCliente(), pagamentoSaidaVeiculo.getValor(), pagamentoSaidaVeiculo.getCliente().getVeiculo().getMovimentacao().getDataEntrada());
                            
                            ec.addPagamento(pagamentoSaidaVeiculo.getModel());
                            
                            veiculoSaida.setModel(pagamentoSaidaVeiculo.getCliente().getVeiculo());
                            
                            for(Vaga v : ec.getVagas()){
                                VagaController vagaSaida = new VagaController();
                                vagaSaida.setModel(v);
                                
                                 if(vagaSaida.getVeiculo().getPlaca().equals(veiculoSaida.getPlaca())){
                                    vagaSaida.setDisponivel(true);
                                    vagaSaida.setVeiculo(null);
                                }
                                
                            }                            
                            for(ClienteController cliente : clientes){
                                if(cliente.getVeiculo().getPlaca().equals(veiculoSaida.getPlaca())){
                                   clientes.remove(cliente); 
                                }
                            }
                            
                           // veiculos.remove(veiculos.indexOf(veiculoSaida));
                            System.out.println(clientes);
                        }
                        
                    } 
                    catch (Exception e) {
                        
                    }
                    break;
                case 4:
                    ec.getView().printFechamento(ec.getPagamentos(), ec.fechamentoCaixa());
                    break;
                case 5:
                    LogSingleton log = LogSingleton.getInstance();
        
                    System.out.println(log.getListaVeiculoController()); 
                    break;
                case 6:
                    appOn = false;
                    break;
            }
            
            
            
        }        

    }
    
}
