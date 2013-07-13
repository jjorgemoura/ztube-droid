ztube-droid
===========

Youtube Player for Android


Trabalho do grupo 14
Elementos: Jorge Moura


Objectivos conseguidos
- Listview de playlists por utilizador
- Listview de videos por playlist selecionada
- Details de videos
- Visualiza��o de videos
- Capacidade de pesquisar playlists de diversos users
- Utiliza��o de Async Calls na chamada da API do Youtube
- Utiliza��o da framework Universal Image Loader para a gest�o das imagens de thumbnails (suporte para mecanismos de cache e async task).
- Defini��o de objectos de domin�o que modelam o meu universo.
- Suporte total para utiliza��o de dados dummy atrav�s da mudan�a de um parametro na class YTApplication
- Utiliza��o de BaseAdapters para alimentar as ListViews.
- SplashScreen (dura��o pode ser ajustada na vari�vel final est�tica na class SplashActivity)
- Javadoc (ok, ainda muito b�sico)
- Google Code Conventions (praticamente a 100%)



Melhorias a efectuar
- UI, nomeadamente melhorar cores, tamanhos de letras, etc.
- No detalhe de videos, meter o logo do user que � o propriet�rio do video que estamos a visualizar.
- Meter um footer de loading nas listviews
- Pagina��o de playlists ou videos nas listviews, quando estas forem muito grandes.
- Meter Nav Up (n�o consegui ainda um funcionamento a 100%)
- Melhorar p�gina e op��es de settings.
- Melhorar suporte para Landscape.
- Melhorar suporte no devide (apenas testado no emulador)
- Internacionaliza��o da aplica��o
- O hist�rico � est�tico, vermos videos n�o altera a ordem do video no hist�rico.
- Falta uma op��o de search para pesquisar por videos a partir de uma string e visualizar os resultados da pesquisa numa listview.
- Melhoria da Action Bar.



Modo de utiliza��o
- Para aceder ao hist�rico, ir a settings e clicar no bot�o para adicinar "dummy data" ao Hist�rico.
- Adicionar userID na p�gina do Settings. Por defeito deve estar a usar o userID "condorouro"
- Como o video � executado no Youtube Player, o emulador ou o Device dever�o ter instalados a App oficial do YouTube.
- 


Created by Jorge Moura (2013).
