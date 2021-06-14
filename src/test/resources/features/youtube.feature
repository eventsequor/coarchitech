#language:es
#Author: eder.carbonero@sophossolutions.com
Característica: Esta es una prueba para el evento Coarquitech

  @UnaCancion
  Escenario: Esta prueba automática busca una canción y me permite quitar los anuncios a los cinco segundos si aparecen
    Dado el nombre de la canción "venom eminen"
    Cuando el sistema hace la busqueda de la canción en youtube
    Y si tiene anuncios publicitarios quitar les

  @MuchasCanciones
  Esquema del escenario: Aca podra seleccionar varias canciones
    Dado el nombre de la canción "<nombreCancion>"
    Cuando el sistema hace la busqueda de la canción en youtube
    Y si tiene anuncios publicitarios quitar les

    Ejemplos: 
      | nombreCancion       |
     # | Robie Williams Feel |
      | venom eminen        |
