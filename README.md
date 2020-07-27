# Projeto final da disciplina MC322 - Programação Orientada a Objetos

## Especificações do projeto:
 
	
 
        Existe uma interface, chamada "Jogavel", que representa as classes de todos os heróis(anão, bárbaro, elfo e feiticeiro). Essa interface foi criada para seguir o princípio de depender de abstrações, ou seja, o restante do projeto dependerá dessa interface e não    das classes dos heróis.    
        Como os heróis tem comportamentos comuns, existe uma classe abstrata, chamada "Heroi", que implementa os atributos e métodos comuns a todos os heróis. As classes Anão e Bárbaro herdam diretamente dessa classe, mas Elfo e Feiticeiro herdam de uma subclasse de Herói, chamada "HeroiMagico", que implementa os métodos comuns apenas a esses dois heróis, ou seja, aqueles relacionados a magias.
Monstros e heróis são filhos também de uma classe chamada SerVivo, assim a magia vai poder ser usada tanto pelos monstros quanto pelos heróis.        
        Os pacotes foram divididos com base na proximidade entre as classes considerando a funcionalidade do jogo. Assim, "personagens" contém monstros, heróis e morcar; já "itens" contém objetos, armas, magias, etc... 
        A classe tabuleiro guarda referência para todos os objetos que devem ser impressos no mapa e implementa os métodos que permitem que o herói interaja diretamente com o mundo ao seu redor, entregando-lhe referências para o que é visível ou alcançável. O herói guarda uma referência para o mapa.
        As classes Corredor e Sala herdam da superclasse abstrata "AreaRetangular". Os objetos dessas classes são construídos da mesma maneira: Definindo-se dois pontos (i,j) do canto superior esquerdo da área e do canto inferior direito. Elas diferem apenas no modo como retornam a visibilidade dos seus elementos interagíveis. A Sala retorna todos os monstros enquanto o Corredor calculará os monstros que estão no campo visível do jogador. Além disso, a posição dos monstros no mapa é lida diretamente de um arquivo ".txt".

