package tabuleiro;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

import excecoes.PosInvalidaException;
import personagens.*;
import personagens.jogaveis.*;

public final class Tabuleiro {
	private int largura;
	private int altura;

//	private char[][] matriz;
	private ArrayList<ArrayList<Character>> matriz;
	String[] mapa_default = { "--------------------------", "-###########--#####P#####-", "-#--#---#--#--#--#---#--#-",
			"-#--P---#--#--P--#---#--#-", "-#--#---P--#--#--#---#--#-", "-#--#---#--#--#--#---#--#-",
			"-####P######--########P##-", "-P------#--------#------P-", "-#------#-##P###-#------#-",
			"-########-#----#-########-", "----------#----#----------", "-########-#----#-########-",
			"-#------#-######-#------#-", "-#------#--------#------#-", "-######P#P##--####P######-",
			"-P----#----#--#----#----P-", "-#----#----#--#----#----#-", "-########P##--###P#######-",
			"--------------------------", };

	private Sala[] salas;
	private Corredor[] corredores;

	private ArrayList<Monstro> monstros; 
//	private ArrayList<Tesouro> tesouros = new ArrayList<Tesouro>();
	private Heroi heroi;

	// ArrayList<Armadilha> armadilhas;

	/*
	 * Construtor Assinatura 1: - Gera um tabuleiro aleatório. Têm como parâmetros
	 * apenas largura e altura do tabuleiro.
	 */
	public Tabuleiro() {
		this.largura = 26;
		this.altura = 19;
		monstros = new ArrayList<Monstro>();
		corredores = new Corredor[12];
		salas = new Sala[15];

		this.matriz = new ArrayList<ArrayList<Character>>();

		int i = 0;
		for (String linha : mapa_default) {
			this.matriz.set(i, new ArrayList<Character>());
			for (char c : linha.toCharArray()) {
				this.matriz.get(i).add(c);
			}
			i++;
		}

		randomize();
	}

	/*
	 * Construtor Assinatura 2: - Gera um tabuleiro a partir a da leitura de um
	 * arquivo. Têm como parâmetros largura, altura e nome do arquivo referente ao
	 * tabuleiro.
	 */
	public Tabuleiro(String nome_arquivo) {
		this.largura = 26;
		this.altura = 19;
		monstros = new ArrayList<Monstro>();
		corredores = new Corredor[12];
		salas = new Sala[15];

		this.matriz = new ArrayList<ArrayList<Character>>();

		int i = 0;
		for (String linha : mapa_default) {
			this.matriz.add(new ArrayList<Character>());
			for (char c : linha.toCharArray()) {
				this.matriz.get(i).add(c);
			}
			i++;
		}

		randomize();
		try {
			File arquivo = new File(nome_arquivo);
			Scanner leitor = new Scanner(arquivo);
			
			monstros = new ArrayList<Monstro>();
			while (leitor.hasNextLine()) {
				String[] linha = leitor.nextLine().split(" ");
//				String[] vetor = new char[3];
//				for (int i = 0; i < linha.length; i++) {
//					vetor[i] = (char) Integer.parseInt(linha[i]);
//				}
				
				Monstro m;
				if(linha[0].equals("G")) {
					m = new Goblin(1, 2, this.heroi);
					m.setTabuleiro(this);
					m.setPosicao(Integer.parseInt(linha[1]), Integer.parseInt(linha[2]));
					this.monstros.add(m);
					
				} 
				else if (linha[0].equals("E")) {
					m = new EsqueletoComum(1, 2, this.heroi);
					m.setTabuleiro(this);
					m.setPosicao(Integer.parseInt(linha[1]), Integer.parseInt(linha[2]));
					
					this.monstros.add(m);
					
				}
				else if (linha[0].equals("M")) {
					m = new EsqueletoMago(1, 2, this.heroi);
					m.setTabuleiro(this);
					m.setPosicao(Integer.parseInt(linha[1]), Integer.parseInt(linha[2]));
					this.monstros.add(m);
				}
				
				
			}
			leitor.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo de tabuleiro não encontrado.");
			e.printStackTrace();
		}

	}

	public void mudarValorMatriz(int i, int j, char valor) {
		this.matriz.get(i).set(j, valor);
		
	}
	
	private void randomize() {
		return;
	}

	// metodo que adiciona uma referencia para o heroi ao mapa
	public void addHeroi(Heroi heroi) {
		this.heroi = heroi;
		this.heroi.setTabuleiro(this); 
		this.heroi.setPosicao(13, 9);
		for (int i = 0; i < this.monstros.size(); i++) {
			this.monstros.get(i).setHeroi(this.heroi);
		}
		this.matriz.get(heroi.getI()).set(heroi.getJ(), heroi.simbolo());
	}

	public void atualizarPosPersonagem(SerVivo p, int novoI, int novoJ) throws PosInvalidaException {
		if (posicaoExiste(novoI, novoJ) && !posicaoOcupada(novoI, novoJ)) {
			apagarCela(p.getI(), p.getJ());
			matriz.get(novoI).set(novoJ, p.simbolo());
		} else {
			throw new PosInvalidaException("Posicao invalida");
		}
	}

	private void apagarCela(int i, int j) {
		// TODO Auto-generated method stub
		matriz.get(i).set(j, '-');

	}

	public boolean posicaoExiste(int i, int j) {
		if (i >= 0 && i < altura && j >= 0 && j < largura) {
			return true;
		}
		return false;
	}

	public boolean posicaoOcupada(int i, int j) {
		if (matriz.get(i).get(j) != '-') {
			return true;
		}
		return false;
	}

	public void printTabuleiro() {
		System.out.println(this.matriz.size());
		System.out.println(this.matriz.get(0).size());
		
		
		for (int i = 0; i < this.matriz.size(); i++) {
			for (int j = 0; j < this.matriz.get(i).size(); j++) {
				System.out.print(this.matriz.get(i).get(j));
			}
			System.out.println("");
		}
	}

	public void movimentaMonstros() {
		for (int i = 0; i < monstros.size(); i++) {
			monstros.get(i).movimenta();
		}
	}

	public ArrayList<Monstro> getMonstrosVisiveis(Heroi heroi, Corredor c) {

		ArrayList<Monstro> monstrosVisiveis = new ArrayList<Monstro>();

		// Busca por monstros em um corredor horizontal
		if (c.isHorizontal()) {
			// procura por monstros à direita do herói, adiciona apenas o primeiro que
			// encontrar
			for (int j = heroi.getJ() + 1; j < this.largura; j++) {
				Monstro m = getMonstroEm(heroi.getI(), j);
				if (m != null) {
					monstrosVisiveis.add(m);
					break;
				}
			}
			// procura por monstros à esquerda do herói, adiciona apenas o primeiro que
			// encontrar
			for (int j = heroi.getJ() - 1; j >= 0; j--) {
				Monstro m = getMonstroEm(heroi.getI(), j);
				if (m != null) {
					monstrosVisiveis.add(m);
					break;
				}
			}
			// Busca por monstros em um corredor vertical
		} else {
			// procura por monstros ao norte do herói, adiciona apenas o primeiro que
			// encontrar
			for (int i = heroi.getI() + 1; i < this.altura; i++) {
				Monstro m = getMonstroEm(i, heroi.getJ());
				if (m != null) {
					monstrosVisiveis.add(m);
					break;
				}
			}
			// procura por monstros ao sul do herói, adiciona apenas o primeiro que
			// encontrar
			for (int i = heroi.getI() - 1; i >= 0; i--) {
				Monstro m = getMonstroEm(i, heroi.getJ());
				if (m != null) {
					monstrosVisiveis.add(m);
					break;
				}
			}
		}

		return monstrosVisiveis;
	}

	private Monstro getMonstroEm(int i, int j) {
		// TODO Auto-generated method stub
		for (Monstro m: this.monstros) {
			if (m.getI() == i && m.getJ() == j) {
				return m;
			}
		} 
		return null;
	}
}
