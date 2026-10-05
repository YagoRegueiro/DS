

public enum Operador {
    suma('+') {
        @Override
        public float executeOperations(float acumulador_0, float acumulador_1) {
            return acumulador_0 + acumulador_1;
        }
        public int tipo_de_prioridad(){
            return 0;
        }
        public String saber_operador(Character car_op) {
            return "suma";        }
    },
    resta('-') {
        @Override
        public float executeOperations(float acumulador_0, float acumulador_1) {
            return acumulador_0 - acumulador_1;
        }
        public int tipo_de_prioridad(){
            return 0;
        }

        public String saber_operador(Character car_op) {
            return "resta";        }
    },
    multiplicacion('*') {
        @Override
        public float executeOperations(float acumulador_0, float acumulador_1) {
            return acumulador_0 * acumulador_1;
        }
        public int tipo_de_prioridad(){
            return 1;
        }
        public String saber_operador(Character car_op) {
            return "multiplicacion";
        }
    },
    division('/') {
        @Override
        public float executeOperations(float acumulador_0, float acumulador_1) {
            return acumulador_0 / acumulador_1;
        }
        public int tipo_de_prioridad(){
            return 1;
        }
        public String saber_operador(Character car_op) {
            return "division";
        }
    },
    sabop('s') {
        @Override
        public float executeOperations(float acumulador_0, float acumulador_1) {
            return 0;
        }

        @Override
        public int tipo_de_prioridad(){
            return -1;
        }

        @Override
        public String saber_operador(Character car_op) {
            switch (car_op) {
                case '+':
                    return "suma";
                case '-':
                    return "resta";
                case '*':
                    return "multiplicacion";
                case '/':
                    return "division";
                default:
                    //Deberia ser redudante por como está estructurado el  código pero por si acaso
                    throw new IllegalArgumentException();
            }
        }
    },
    ;
    private final char op;

    Operador(char c) {
        this.op = c;
    }

    public abstract float executeOperations(float acumulador_0, float acumulador_1);

    public abstract String saber_operador(Character car_op);

    public abstract int tipo_de_prioridad();







}
