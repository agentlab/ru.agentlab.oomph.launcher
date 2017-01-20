/**
 *
 */
package ru.agentlab.oomph.launcher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * @author Дмитрий
 *
 */
public class Parser {

    private ArrayList<String> labels = new ArrayList<>();

    public Parser() {
        parse();
    }

    public ArrayList<String> getLabels() {
        return this.labels;
    }

    private ArrayList<String> readFile() {
        ArrayList<String> lines = new ArrayList<>();
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("d:\\setups.setup")); //$NON-NLS-1$
            String line;
            while ((line = br.readLine()) != null)
            {
                lines.add(line);
            }
            br.close();
        }
        catch (Exception e)
        {
            System.out.println("No such file or directory"); //$NON-NLS-1$
        }
        return lines;
    }

    private void parse() {
        ArrayList<String> setups = readFile();
        String setup = ""; //$NON-NLS-1$
        for (int i = 0; i < setups.size(); i++)
        {
            if (setups.get(i).contains("<product name")) //$NON-NLS-1$
            {
                setup = setups.get(i + 1);
                int startInd = 0;
                int endInd = 0;
                for (int j = 0; j < setup.length(); j++)
                {
                    if (setup.charAt(j) == '"' && startInd != 0)
                    {
                        endInd = j;
                    }
                    if (setup.charAt(j) == '"' && startInd == 0)
                    {
                        startInd = j + 1;
                    }
                }
                setup = setup.substring(startInd, endInd);
                labels.add(setup);
            }

        }
    }

}
