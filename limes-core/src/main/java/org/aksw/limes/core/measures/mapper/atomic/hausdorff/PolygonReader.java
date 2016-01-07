/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aksw.limes.core.measures.mapper.atomic.hausdorff;

import org.aksw.limes.core.datastrutures.Point;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

/**
 *
 * @author ngonga
 */
public class PolygonReader {
    private static final Logger logger = Logger.getLogger(PolygonReader.class.getName());

    public static boolean keepPolygons = true;

    public static Set<Polygon> readPolygons(String file) {
	return readPolygons(file, -1);
    }

    public static Set<Polygon> readPolygons(String file, int numberOfEntries) {
		long startTime = System.currentTimeMillis();
		Map<String, Polygon> result = new HashMap<String, Polygon>();
		String s, split[];
		try {
			BufferedReader buf = new BufferedReader(new FileReader(file));
			s = buf.readLine();
			while (s != null) {
				while (s.contains("  ")) {
					s = s.replaceAll(Pattern.quote("  "), " ");
				}
				s = s.replaceAll(Pattern.quote(" "), "\t");
				split = s.split("\t");
				if (split.length % 2 != 1) {
					System.err.println("Error: " + split.length + " => " + s);
				} else {
					if (!result.containsKey(split[0])) {
						result.put(split[0], new Polygon(split[0]));
					}
					// data is stored as long, lat
					for (int i = 1; i < split.length; i = i + 2) {
						result.get(split[0]).add(new Point("", Arrays.asList(
								new Double[] { Double.parseDouble(split[i + 1]), Double.parseDouble(split[i]) })));
					}
				}
				if (result.keySet().size() == numberOfEntries) {
					break;
				}
				s = buf.readLine();
				buf.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Set<Polygon> r = new HashSet<Polygon>();
		if (keepPolygons) {
			for (Polygon p : result.values()) {
				r.add(p);
			}
			logger.info("Read " + r.size() + " polygons done in " + (System.currentTimeMillis() - startTime) + "ms.");
			return r;
		} else {
			logger.info(
					"Read " + result.size() + " polygons done in " + (System.currentTimeMillis() - startTime) + "ms.");
			return new HashSet<Polygon>(result.values());
		}
	}

    public static void main(String args[]) {
	Set<Polygon> result = readPolygons("resources/nuts/nuts_geometry.csv");
	for (Polygon p : result) {
	    System.out.println(p.uri + "\t" + p.points.size());
	}

    }
}
