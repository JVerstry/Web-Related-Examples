
package xyz.sample.baremvc;

import java.util.Comparator;
import org.springframework.stereotype.Service;

@Service
public class CaseInsensitiveComparator implements Comparator<String> {
	
	@Override
    public int compare(String s1, String s2) {
        assert s1 != null && s2 != null;
        return String.CASE_INSENSITIVE_ORDER.compare(s1, s2);
    }
	
}
