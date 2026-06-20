    package SystemDesign;

    import java.util.HashMap;
    import java.util.Map;

    interface SendNotification {
        void send(String message);
    }

    // SMS Notification
    class SMSNotification implements SendNotification {

        @Override
        public void send(String message) {
            System.out.println("Sending SMS: " + message);
        }
    }

    // Email Notification
    class EmailNotification implements SendNotification {

        @Override
        public void send(String message) {
            System.out.println("Sending Email: " + message);
        }
    }

    // Push Notification
    class PushNotification implements SendNotification {

        @Override
        public void send(String message) {
            System.out.println("Sending Push Notification: " + message);
        }
    }

    // Template Engine
    class TemplateEngine {

        public String renderTemplate(String template, Map<String, String> data) {

            for (Map.Entry<String, String> entry : data.entrySet()) {
                template = template.replace("{{" + entry.getKey() + "}}", entry.getValue());
            }

            return template;
        }
    }

    // Notification Service
    class NotificationService {

        private SendNotification notification;

        public NotificationService(SendNotification notification) {
            this.notification = notification;
        }

        public void sendNotification(String template, Map<String, String> data) {

            TemplateEngine engine = new TemplateEngine();
            String message = engine.renderTemplate(template, data);
            notification.send(message);
        }
    }

    public class NotificationSystem {

        public static void main(String[] args) {

            // Template
            String template = "Hello {{name}}, your order {{orderId}} is shipped.";

            // Data
            Map<String, String> data = new HashMap<>();
            data.put("name", "Abhishek");
            data.put("orderId", "ORD123");

            // SMS Notification
            NotificationService smsService = new NotificationService(new SMSNotification());

            smsService.sendNotification(template, data);

            // Email Notification
            NotificationService emailService = new NotificationService(new EmailNotification());

            emailService.sendNotification(template, data);

            // Push Notification
            NotificationService pushService = new NotificationService(new PushNotification());

            pushService.sendNotification(template, data);
        }
    }