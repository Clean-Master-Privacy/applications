const API_KEY = 'YOUR_VIRUSTOTAL_API_KEY'; // Buraya kendi API anahtarınızı ekleyin.
const result = document.getElementById('result');

document.getElementById('scanBtn').addEventListener('click', async function() {
    const fileList = document.getElementById('fileInput').files;
    result.innerHTML = '<h3>Taramanın Sonucu:</h3>';
    
    for (let i = 0; i < fileList.length; i++) {
        const file = fileList[i];

        // Dosyayı oku
        const fileContent = await readFile(file);
        
        // Virustotal'a gönder
        const responseData = await scanFileWithVirusTotal(fileContent);
        
        // Yanıtlara göre kullanıcıya bilgi ver
        if (responseData) {
            const isMalicious = responseData.positives > 0;
            const totalEngines = responseData.total;

            if (isMalicious) {
                result.innerHTML += `<p style="color: red;">Zararlı dosya bulundu: ${file.name} (Pozitif Tespit: ${responseData.positives}/${totalEngines})</p>`;
            } else {
                result.innerHTML += `<p style="color: green;">Güvenli dosya: ${file.name} (Pozitif Tespit: ${responseData.positives}/${totalEngines})</p>`;
            }
        }
    }
});

// Dosyayı okuyarak base64 formatına dönüştür
function readFile(file) {
    return new Promise((resolve) => {
        const reader = new FileReader();
        reader.onloadend = () => {
            resolve(reader.result.split(',')[1]); // Base64 kodunun yalnızca iç kısmını al
        };
        reader.readAsDataURL(file);
    });
}

// Virustotal API'sine dosya gönderme
async function scanFileWithVirusTotal(fileContent) {
    const url = 'https://www.virustotal.com/api/v3/files';
    try {
        // Dosya içeriğini Virustotal API'sine gönder
        const response = await axios.post(url, {
            file: fileContent
        }, {
            headers: {
                'x-apikey': API_KEY,
                'Content-Type': 'application/json'
            }
        });

        const analysisID = response.data.data.id;
        // Analiz sonucunu almak için bekliyoruz
        const analysisResult = await getAnalysisResult(analysisID);
        return analysisResult;
    } catch (error) {
        console.error('Virustotal API hatası:', error.response);
        return null;
    }
}

// Analiz sonucunu al
async function getAnalysisResult(analysisID) {
    const url = `https://www.virustotal.com/api/v3/analyses/${analysisID}`;
    try {
        const response = await axios.get(url, {
            headers: {
                'x-apikey': API_KEY
            }
        });
        return response.data.data.attributes;
    } catch (error) {
        console.error('Analiz sonucu alma hatası:', error.response);
        return null;
    }
}
