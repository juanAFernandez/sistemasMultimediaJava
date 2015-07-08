/*
        This program is free software: you can redistribute it and/or modify
        it under the terms of the GNU General Public License as published by
        the Free Software Foundation, either version 3 of the License, or
        (at your option) any later version.
        This program is distributed in the hope that it will be useful,
        but WITHOUT ANY WARRANTY; without even the implied warranty of
        MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
        GNU General Public License for more details.
        You should have received a copy of the GNU General Public License
        along with this program. If not, see <http://www.gnu.org/licenses/>.
      
        Copyright 2015 Juan A. Fernández Sánchez
*/
package extras;

/**
 * Enumerado para el control de las herramientas en uso.
 * Usado en varias secciones del código, sobre todo en la gestión de los eventos del mouse.
 * @author Juan A. Fernández Sánchez
 */
public enum Herramienta {
    PUNTO,
    LINEA,
    CURVA_CUADRATICA,
    CURVA_CUBICA,
    RECTANGULO,
    RECTANGULO_REDONDEADO,
    OVALO,
    ARCO,
    POLILINEA,
    TEXTO
}
