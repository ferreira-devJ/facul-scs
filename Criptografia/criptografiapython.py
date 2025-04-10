def xor_cipher(text, key):
    """
    Criptografa e descriptografa uma string usando a cifra XOR.
    
    :param text: Texto (string) a ser criptografado/descriptografado.
    :param key: Chave de criptografia (string).
    :return: Texto criptografado ou descriptografado.
    """
    # Convertendo a chave em um número baseado na soma dos valores dos caracteres
    key_int = sum([ord(c) for c in key])
    
    # Criptografando ou descriptografando usando XOR
    result = ''.join([chr(ord(c) ^ key_int) for c in text])
    
    return result


# Testando a criptografia
texto_original = "Mensagem secreta!"
chave = "minha_chave"

# Criptografando
texto_criptografado = xor_cipher(texto_original, chave)
print("Texto criptografado:", texto_criptografado)

# Descriptografando
texto_descriptografado = xor_cipher(texto_criptografado, chave)
print("Texto descriptografado:", texto_descriptografado)
