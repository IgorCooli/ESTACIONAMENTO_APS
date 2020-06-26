/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estacionamento_aps;

import controller.AtribuiLog;
import controller.ClienteController;
import controller.Command.ProcessarPagamentoCartao;
import controller.Command.ProcessarPagamentoDinheiro;
import controller.EstacionamentoController;
import controller.Memento.PagamentoMemento;
import controller.MovimentacaoController;
import controller.PagamentoController;
import controller.Strategy.CalcularPagamentoCartao;
import controller.Strategy.CalcularPagamentoDinheiro;
import controller.VagaCarroController;
import controller.VagaCarroFactory;
import controller.VagaMotoController;
import controller.VagaMotoFactory;
import controller.VeiculoController;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import model.LogSingleton;
import model.TipoPagamento;
import model.Vaga;
import model.VagaCarro;
import model.VagaMoto;

/**
 *
 * @author coliv
 */
public class Estacionamento_APS {

    public static void main(String[] args) {
        

                
        Scanner tc = new Scanner(System.in);
        
        AtribuiLog atribuiLog = new AtribuiLog();             
        VagaCarroFactory vagaCarroFactory = new VagaCarroFactory();
        VagaMotoFactory vagaMotoFactory = new VagaMotoFactory();
        ClienteController cc = new ClienteController();
        VeiculoController vc = new VeiculoController();
        MovimentacaoController mc = new MovimentacaoController();
        EstacionamentoController ec = new EstacionamentoController();
        
        ArrayList<PagamentoController> pagamentos = new ArrayList<>();
        ArrayList<ClienteController> clientes = new ArrayList<>();
        
        // Capacidade máxima do estacionamento é 500.
        int capacidadeCarro = 20;
        int capacidadeMoto = 30;
        
        
        for(int i = 0; i < capacidadeCarro; i++){
            VagaCarroController vaga = new VagaCarroController();
            vaga.setModel((VagaCarro) vagaCarroFactory.criarVaga());
            vaga.setNumero(i + 1);
            vaga.setDisponivel(true);  
            vaga.setTipo(1);
            ec.addVagaCarro(vaga.getModel());
        }
        
        for(int i = 0; i < capacidadeCarro; i++){
            VagaMotoController vaga = new VagaMotoController();
            vaga.setModel((VagaMoto) vagaMotoFactory.criarVaga());
            vaga.setNumero(i + 1);
            vaga.setDisponivel(true);          
            vaga.setTipo(2);
            ec.addVagaMoto(vaga.getModel());
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
                // TODO: CRIAR METODO PARA ENTRADA DE MOTO
                case 1:
                   // ENTRADA DE VEÍCULOS
                   try{
                        ClienteController clienteCadastro = new ClienteController();
                        VeiculoController vCadastro = new VeiculoController();
                        VagaCarroController vagaCadastro = new VagaCarroController();
                        
                        for(VagaCarro vaga : ec.getVagasCarro()){
                            VagaCarroController vagaCont = new VagaCarroController();
                            vagaCont.setModel(vaga);
                            vagaCont.getView().printVaga(vaga.getNumero(), vaga.isDisponivel(), vaga.getTipo());
                        }
                        
                        for(VagaMoto vaga : ec.getVagasMoto()){
                            VagaMotoController vagaCont = new VagaMotoController();
                            vagaCont.setModel(vaga);
                            vagaCont.getView().printVaga(vaga.getNumero(), vaga.isDisponivel(), vaga.getTipo());
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
                        
                        
                        for(VagaCarro vaga : ec.getVagasCarro()){
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
                // TODO: CRIAR METODO PARA VISUALISAR VAGAS DE MOTO
                case 2:
                    // LISTAR VEICULOS ESTACIONADOS
                    vc.getView().listarVeiculos();
                    
                    for(VagaCarro vagas : ec.getVagasCarro()){
                        
                        VagaCarroController vaga = new VagaCarroController();
                        VeiculoController veiculo = new VeiculoController();
                        
                        vaga.setModel(vagas);
                        if(!vaga.getDisponivel())  {
                            vaga.getView().printVaga(vaga.getNumero(), vaga.getDisponivel(), vaga.getTipo());
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
                // TODO: CRIAR METODO PARA SAIDA DE MOTO    
                case 3:
                    // SAÍDA DE VEÍCULOS
                    // TODO: usar o atribuiLog para adicionar o carro na lista do log
                    try {                        
                        
                        ec.getView().saidaVeiculo();
                        String plVeiculoSaida = tc.next();
                        VeiculoController veiculoSaida = new VeiculoController();
                        PagamentoController pagamentoSaidaVeiculo = new PagamentoController();
                        ClienteController clienteSaida = new ClienteController();
                        VagaCarroController vaga = new VagaCarroController();
                        
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
                            
                            int tipoPagamentoVeiculo;
                            
                            Date saida = new Date();
                            formata.format(saida);  
                            // Setando a hora de saída do cliente
                            clienteSaida.getVeiculo().getMovimentacao().setDataSaida(saida);
                            pagamentoSaidaVeiculo.setData(saida);
                            
                            System.out.println(formata.format(clienteSaida.getVeiculo().getMovimentacao().getDataSaida()));
                            
                            pagamentoSaidaVeiculo.setCliente(clienteSaida.getModel());
                            
                            pagamentoSaidaVeiculo.getView().printTipoPagamento();
                            tipoPagamentoVeiculo =  tc.nextInt();
                            
                            /* CALCULANDO A ESTADIA DO CARRO EM SEGUNDOS */
                             //TRANSFORMAR OS MILISEGUNDOS EM SEGUNDOS
                            double diffSeconds = (pagamentoSaidaVeiculo.getDateDiff(dataEntrada,clienteSaida.getVeiculo().getMovimentacao().getDataSaida(), TimeUnit.SECONDS)/1000); 
                            
                            /* VERIFICANDO O TIPO DE PAGAMENTO E JÁ FAZENDO O CÁLCULO DO VALOR A PAGAR */
                            if(tipoPagamentoVeiculo == 1){
                                pagamentoSaidaVeiculo.setTipoPagamento(TipoPagamento.CARTAO);
                                CalcularPagamentoCartao pgCartao = new CalcularPagamentoCartao();
                                pagamentoSaidaVeiculo.setValor(pgCartao.calculaValorPagamento(diffSeconds));
                                
                                System.out.println("Processando pagamento...");
                                System.out.println(" ... ");
                                System.out.println(" ... "); 
                                
                                ProcessarPagamentoCartao ppgCartao = new ProcessarPagamentoCartao();
                                ppgCartao.processarPagamento(pagamentoSaidaVeiculo);
                            }
                            else {
                                pagamentoSaidaVeiculo.setTipoPagamento(TipoPagamento.DINHEIRO);
                                CalcularPagamentoDinheiro pgDinheiro = new CalcularPagamentoDinheiro();
                                pagamentoSaidaVeiculo.setValor(pgDinheiro.calculaValorPagamento(diffSeconds));
                                
                                System.out.println("Processando pagamento...");
                                System.out.println(" ... ");
                                System.out.println(" ... "); 
                                
                                ProcessarPagamentoDinheiro ppgDinheiro = new ProcessarPagamentoDinheiro();
                                ppgDinheiro.processarPagamento(pagamentoSaidaVeiculo);

                            }                                         
                            
                            ec.addPagamento(pagamentoSaidaVeiculo.getModel());
                            
                            veiculoSaida.setModel(pagamentoSaidaVeiculo.getCliente().getVeiculo());
                            
                            for(VagaCarro v : ec.getVagasCarro()){
                                VagaCarroController vagaSaida = new VagaCarroController();
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
                    ec.getView().printSubMenuPagamentos();
                    opcaoEscolhida = tc.nextInt();
                    
                    if(opcaoEscolhida == 1){
                        
                        
                        // TODO - AJUSTAR PARA PEGAR O ULTIMO VALOR DE UMA LISTA.
                        int ultimo = ec.getPagamentos().size();
                        ultimo = ultimo - 1;
                        PagamentoMemento memento = new PagamentoMemento();
                        // RECUPERANDO O ESTADO DO ULTIMO LISTA DE PAGAMENTOS.
                        memento.setPagamentosMemento(ec.getPagamentos());                        
                        
                                                
                        System.out.println("Ultimo Pagamento:" + memento.getPagamentosMemento().get(ultimo).getValor() +
                                           "\n" + "DATA ULTIMO PAGAMENTO:" + memento.getPagamentosMemento().get(ultimo).getDataPagamento() +
                                           "\n" + "TIPO PAGAMENTO:" + memento.getPagamentosMemento().get(ultimo).getTipoPagamento()
                                           );                        
                    }
                    else
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
