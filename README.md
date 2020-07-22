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