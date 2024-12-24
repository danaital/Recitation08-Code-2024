public class TrafficLightDecider {

    public TrafficLightEnum getNextLight (TrafficLightEnum light) {
        TrafficLightEnum nextLight = TrafficLightEnum.RED;
        switch (light) {
            case RED:
                nextLight = TrafficLightEnum.GREEN;
                break;
            case YELLOW:
                nextLight = TrafficLightEnum.RED;
                break;
            case GREEN:
                nextLight = TrafficLightEnum.YELLOW;
                break;
            default:
                nextLight = TrafficLightEnum.RED;
                break;
        }
        System.out.println("The current light is " + light + " so the next light is " + nextLight);
        return nextLight;
    }
    public CarActionEnum decide(TrafficLightEnum light) {
        CarActionEnum action = CarActionEnum.STOP;
        switch (light) {
            case RED:
                action = CarActionEnum.STOP;
                break;
            case YELLOW:
                action = CarActionEnum.SLOW_DOWN;
                break;
            case GREEN:
                action = CarActionEnum.GO;
                break;
            default:
                action = CarActionEnum.STOP;
                break;
        }
        System.out.println("The light is " + light + " so the car should " + action);

        return action;
    }

    public static void iterateEnum() {
        TrafficLightEnum[] lights = TrafficLightEnum.values();
        for (int i = 0; i < lights.length; i++) {
            System.out.println(lights[i]);
        }
    }
    public static void main(String[] args) {
        TrafficLightDecider decider = new TrafficLightDecider();
        decider.decide(TrafficLightEnum.RED);
        decider.decide(TrafficLightEnum.YELLOW);
        decider.decide(TrafficLightEnum.GREEN);
    }
}
