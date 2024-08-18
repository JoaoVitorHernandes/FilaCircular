public class Main {
    public static void main(String[] args) {
        CircularQueue<Integer> queue = new CircularQueue<>(5);

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        try {
            queue.add(6);
        } catch (IllegalStateException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("Removido: " + queue.remove());
        System.out.println("Removido: " + queue.remove());

        queue.add(6);
        queue.add(7);

        while (!queue.isEmpty()) {
            System.out.println("Removido: " + queue.remove());
        }

        System.out.println("Fila está vazia? " + queue.isEmpty());

        queue.clear();
        System.out.println("Fila foi limpa. Está vazia? " + queue.isEmpty());
    }
}