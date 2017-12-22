package Presentation.Utillities;

import Business.Exception.NewException;

/**
 * Klasssen bruges til at vise kunden valgmuligheder køb af carport og skur
 *
 */
public class RendUtilCustomerPresentation {

    /**
     *
     * @return en dropdown menu med længde, bredde og højde.
     * @throws NewException ved fejl.
     */
    public static String getMeasures() throws NewException {

        StringBuilder sb = new StringBuilder();

        sb.append(" <table border=4>\n"
                + "                <tr>\n"
                + "                    <th>Carport Længde</th>\n"
                + "                    <th>Carport Bredde</th>\n"
                + "                    <th>Carport Højde<br>(Standard)</th>\n"
                + "\n"
                + "                </tr>\n"
                + "              \n"
                + "                <tr>\n"
                + "\n"
                + "                    <td>\n"
                + "                        <select name=\"lentgchoice\">\n"
                + "                            <option number=\"240\">240</option>\n"
                + "                            <option number=\"270\">270</option>\n"
                + "                            <option number=\"300\">300</option>\n"
                + "                            <option number=\"330\">330</option>\n"
                + "                            <option number=\"360\">360</option>\n"
                + "                            <option number=\"390\">390</option>\n"
                + "                            <option number=\"420\">420</option>\n"
                + "                            <option number=\"450\">450</option>\n"
                + "                            <option number=\"480\">480</option>\n"
                + "                            <option number=\"510\">510</option>\n"
                + "                            <option number=\"540\">540</option>\n"
                + "                            <option number=\"570\">570</option>\n"
                + "                            <option number=\"600\">600</option>\n"
                + "                            <option number=\"630\">630</option>\n"
                + "                            <option number=\"660\">660</option>\n"
                + "                            <option number=\"660\">690</option>\n"
                + "                            <option number=\"720\">720</option>\n"
                + "                            <option number=\"750\">750</option>\n"
                + "                            <option number=\"780\">780</option>\n"
                + "                        </select>\n"
                + "                    </td>\n"
                + "\n"
                + "                    <td>\n"
                + "                        <select name=\"widthchoice\">\n"
                + "                            <option number=\"240\">240</option>\n"
                + "                            <option number=\"270\">270</option>\n"
                + "                            <option number=\"300\">300</option>\n"
                + "                            <option number=\"330\">330</option>\n"
                + "                            <option number=\"360\">360</option>\n"
                + "                            <option number=\"390\">390</option>\n"
                + "                            <option number=\"420\">420</option>\n"
                + "                            <option number=\"450\">450</option>\n"
                + "                            <option number=\"480\">480</option>\n"
                + "                            <option number=\"510\">510</option>\n"
                + "                            <option number=\"540\">540</option>\n"
                + "                            <option number=\"570\">570</option>\n"
                + "                            <option number=\"600\">600</option>\n"
                + "                            <option number=\"630\">630</option>\n"
                + "                            <option number=\"660\">660</option>\n"
                + "                            <option number=\"660\">690</option>\n"
                + "                            <option number=\"720\">720</option>\n"
                + "                            <option number=\"750\">750</option>\n"
                + "                        </select>\n"
                + "                    </td>\n"
                + "\n"
                + "                    <td>\n"
                + "                        <select name=\"heightchoice\">\n"
                + "                            <option number=\"225\">225</option>\n"
                + "                        </select>\n"
                + "                    </td>\n"
                + "                </tr>\n"
                + "            </table>");

        return sb.toString();

    }

    /**
     *
     * @return en dropdown menu for skurets længde, bredde og højde.
     * @throws NewException ved fejl.
     */
    public static String getMeasuresShed() throws NewException {

        StringBuilder sb = new StringBuilder();

        sb.append("    <table border=4>\n"
                + "                    <tr>\n"
                + "                        <th>Skur Længde</th>\n"
                + "                        <th>Skur Bredde</th>\n"
                + "                        <th>Skur Højde<br>(Standard)</th>\n"
                + "\n"
                + "                    </tr>\n"
                + "\n"
                + "                    <tr>\n"
                + "\n"
                + "                        <td><select name=\"lentgchoiceskur\">\n"
                + "                                <option number=\"0\" value=\"0\"> Fravalgt</option>\n"
                + "                                <option number=\"210\">210</option>\n"
                + "                                <option number=\"240\">240</option>\n"
                + "                                <option number=\"270\">270</option>\n"
                + "                                <option number=\"300\">300</option>\n"
                + "                                <option number=\"330\">330</option>\n"
                + "                                <option number=\"360\">360</option>\n"
                + "                                <option number=\"390\">390</option>\n"
                + "                                <option number=\"420\">420</option>\n"
                + "                                <option number=\"450\">450</option>\n"
                + "                                <option number=\"480\">480</option>\n"
                + "                                <option number=\"510\">510</option>\n"
                + "                                <option number=\"540\">540</option>\n"
                + "                                <option number=\"570\">570</option>\n"
                + "                                <option number=\"600\">600</option>\n"
                + "                                <option number=\"630\">630</option>\n"
                + "                                <option number=\"660\">660</option>\n"
                + "                                <option number=\"660\">690</option>\n"
                + "                                <option number=\"720\">720</option>\n"
                + "\n"
                + "                            </select>\n"
                + "\n"
                + "                        </td>\n"
                + "\n"
                + "                        <td><select name=\"widthchoiceskur\">\n"
                + "                                <option number=\"0\" value=\"0\"> Fravalgt</option>\n"
                + "                                <option number=\"150\">150</option>\n"
                + "                                <option number=\"180\">180</option>\n"
                + "                                <option number=\"210\">210</option>\n"
                + "                                <option number=\"240\">240</option>\n"
                + "                                <option number=\"270\">270</option>\n"
                + "                                <option number=\"300\">300</option>\n"
                + "                                <option number=\"330\">330</option>\n"
                + "                                <option number=\"360\">360</option>\n"
                + "                                <option number=\"390\">390</option>\n"
                + "                                <option number=\"420\">420</option>\n"
                + "                                <option number=\"450\">450</option>\n"
                + "                                <option number=\"480\">480</option>\n"
                + "                                <option number=\"510\">510</option>\n"
                + "                                <option number=\"540\">540</option>\n"
                + "                                <option number=\"570\">570</option>\n"
                + "                                <option number=\"600\">600</option>\n"
                + "                                <option number=\"630\">630</option>\n"
                + "                                <option number=\"660\">660</option>\n"
                + "                                <option number=\"660\">690</option>\n"
                + "\n"
                + "                            </select></td>    \n"
                + "\n"
                + "                        <td> <select name=\"heightchoiceskur\">\n"
                + "                                <option number=\"0\" value=\"0\"> Fravalgt</option>\n"
                + "                                <option number=\"210\">210</option>\n"
                + "                            </select></td>\n"
                + "\n"
                + "                    </tr>\n"
                + "</table>");

        return sb.toString();

    }
}
