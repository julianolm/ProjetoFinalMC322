# Projeto final da disciplina MC322 - Programação Orientada a Objetos

## Especificações do projeto:
 
	1) Classes dos personagens do jogo:
		
		Existe uma interface, chamada "Jogavel", que representa as classes de todos os herois 
		(anao, barbaro, elfo e feiticeiro). Essa interface foi criada para seguir o principio de
		 depender de abstracoes, ou seja, o restante do projeto dependera dessa interface e nao 
		 das classes dos herois.
		
		Como os herois tem comportamentos comuns, existe uma classe abstrata, chamada "Heroi", 
		que implementa os atributos e metodos comuns a todos os herois. as classes Anao e 
		Barbaro herdam diretamente dessa classe, mas Elfo e Feiticeiro herdam de uma subclasse 
		de Heroi, chamada "HeroiMagico", que implementa os metodos comuns apenas a esses dois 
		herois, ou seja, aqueles relacionados a magias.
		
		Os pacotes foram divididos com base na proximidade entre as classes considerando a
		funcionalidade do jogo. Assim, "personagens" contem monstros, herois e morcar; "itens" 
		contem objetos, armas, magias, etc... 
		
		A classe tabuleiro guarda referencia para todos os objetos que devem ser impressos no mapa
		e implementa os metodos que permitem que o heroi interaja diretamente com o mundo ao seu
		redor, entregando-lhe referencias para o que lhe eh visivel ou alcancavel. O heroi guarda
		uma referencia para o mapa.
