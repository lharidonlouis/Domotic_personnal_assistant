package objects;

import java.util.Map;

import counters.Clock;

public interface DbSetter {
    public void setMap(Map map);
    public void setClock(Clock clock);
}
