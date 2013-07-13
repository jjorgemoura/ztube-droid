ztube-droid
===========

Youtube Player for Android


Trabalho do grupo 14
Elementos: Jorge Moura


Objectivos conseguidos
- Listview de playlists por utilizador
- Listview de videos por playlist selecionada
- Details de videos
- Visualização de videos
- Capacidade de pesquisar playlists de diversos users
- Utilização de Async Calls na chamada da API do Youtube
- Utilização da framework Universal Image Loader para a gestão das imagens de thumbnails (suporte para mecanismos de cache e async task).
- Definição de objectos de dominío que modelam o meu universo.
- Suporte total para utilização de dados dummy através da mudança de um parametro na class YTApplication
- Utilização de BaseAdapters para alimentar as ListViews.
- SplashScreen (duração pode ser ajustada na variável final estática na class SplashActivity)
- Javadoc (ok, ainda muito básico)
- Google Code Conventions (praticamente a 100%)



Melhorias a efectuar
- UI, nomeadamente melhorar cores, tamanhos de letras, etc.
- No detalhe de videos, meter o logo do user que é o proprietário do video que estamos a visualizar.
- Meter um footer de loading nas listviews
- Paginação de playlists ou videos nas listviews, quando estas forem muito grandes.
- Meter Nav Up (não consegui ainda um funcionamento a 100%)
- Melhorar página e opções de settings.
- Melhorar suporte para Landscape.
- Melhorar suporte no devide (apenas testado no emulador)
- Internacionalização da aplicação
- O histórico é estático, vermos videos não altera a ordem do video no histórico.
- Falta uma opção de search para pesquisar por videos a partir de uma string e visualizar os resultados da pesquisa numa listview.
- Melhoria da Action Bar.



Modo de utilização
- Para aceder ao histórico, ir a settings e clicar no botão para adicinar "dummy data" ao Histórico.
- Adicionar userID na página do Settings. Por defeito deve estar a usar o userID "condorouro"
- Como o video é executado no Youtube Player, o emulador ou o Device deverão ter instalados a App oficial do YouTube.
- 


Created by Jorge Moura (2013).
