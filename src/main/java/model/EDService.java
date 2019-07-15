package model;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import utils.CsvParser;

@Service
public class EDService {
	
	public Collection getMetadata() 
	{
		int i=0;
		List <MetaData> Meta = new ArrayList();
		String meta[]=CsvParser.metad();
		Field[] field= ErasmusData.class.getDeclaredFields();
		for (Field o : field) {
            MetaData newMeta = new MetaData();
            newMeta.setType(o.getType().getSimpleName());
            newMeta.setSourceField(meta[i]);
            Meta.add(newMeta);
            i+=1;
        }
        return Meta;
		
		
	}
}
