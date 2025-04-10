import java.security.*;
import javax.crypto.Cipher;
import java.util.Base64;

public class CriptografiaRSA {

    // Método para gerar o par de chaves (pública e privada)
    public static KeyPair gerarChaves() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);  // Tamanho da chave (2048 bits é comum)
        return keyPairGenerator.generateKeyPair();
    }

    // Método para criptografar a mensagem com a chave pública
    public static String criptografar(String textoOriginal, PublicKey chavePublica) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, chavePublica);
        byte[] textoCriptografado = cipher.doFinal(textoOriginal.getBytes());
        return Base64.getEncoder().encodeToString(textoCriptografado);
    }

    // Método para descriptografar a mensagem com a chave privada
    public static String descriptografar(String textoCriptografado, PrivateKey chavePrivada) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, chavePrivada);
        byte[] textoDecodificado = Base64.getDecoder().decode(textoCriptografado);
        byte[] textoOriginal = cipher.doFinal(textoDecodificado);
        return new String(textoOriginal);
    }

    public static void main(String[] args) {
        try {
            // Gerar o par de chaves (pública e privada)
            KeyPair chavePar = gerarChaves();
            PublicKey chavePublica = chavePar.getPublic();
            PrivateKey chavePrivada = chavePar.getPrivate();

            // Texto para criptografar
            String texto = "Mensagem secreta com RSA";

            // Criptografar o texto com a chave pública
            String textoCriptografado = criptografar(texto, chavePublica);
            System.out.println("Texto Criptografado: " + textoCriptografado);

            // Descriptografar o texto com a chave privada
            String textoDescriptografado = descriptografar(textoCriptografado, chavePrivada);
            System.out.println("Texto Descriptografado: " + textoDescriptografado);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
