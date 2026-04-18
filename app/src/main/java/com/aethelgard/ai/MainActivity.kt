import React, { useState } from 'react';
import { 
  Cpu, 
  Zap, 
  UserCheck, 
  FileText, 
  Lock, 
  ChevronRight, 
  Search, 
  Leaf,
  Settings,
  ShieldAlert
} from 'lucide-react';

// Simulando o tema Material 3 do Android
const App = () => {
  const [currentTab, setCurrentTab] = useState('RH');
  const [industry, setIndustry] = useState('Geral');
  const [isSecret, setIsSecret] = useState(false);
  const [workerNote, setWorkerNote] = useState('');

  // Simulação de componentes nativos do Android
  return (
    <div className="flex flex-col h-screen bg-[#1c1b1f] text-[#e6e1e5] font-sans max-w-md mx-auto border-x border-slate-800 shadow-2xl overflow-hidden">
      
      {/* Top App Bar (Android style) */}
      <header className="px-4 py-6 bg-[#1c1b1f] flex justify-between items-center border-b border-slate-800">
        <div className="flex items-center gap-3">
          <div className="bg-[#d0bcff] p-1.5 rounded-lg text-[#381e72]">
            <Cpu size={20} />
          </div>
          <h1 className="text-xl font-medium tracking-tight">Aethelgard AI</h1>
        </div>
        <Settings size={20} className="text-[#938f99]" />
      </header>

      {/* Main Content Area */}
      <main className="flex-1 overflow-y-auto p-4 space-y-6">
        
        {currentTab === 'Branding' && (
          <div className="space-y-4 animate-in fade-in duration-500">
            <h2 className="text-2xl font-bold text-[#d0bcff]">Naming Estratégico</h2>
            <p className="text-[#938f99] text-sm">Gerador de nomes com foco em sigilo fonético e sustentabilidade.</p>
            
            <div className="bg-[#2b2930] p-4 rounded-2xl space-y-4">
              <label className="text-xs font-bold uppercase text-[#d0bcff]">Setor</label>
              <select 
                value={industry}
                onChange={(e) => setIndustry(e.target.value)}
                className="w-full bg-[#49454f] p-3 rounded-xl border-none text-white focus:ring-2 ring-[#d0bcff] outline-none"
              >
                <option>Geral</option>
                <option>Tecnologia</option>
                <option>Indústria</option>
                <option>Saúde</option>
              </select>

              <button 
                onClick={() => setIsSecret(!isSecret)}
                className={`w-full p-4 rounded-xl flex items-center justify-between border-2 transition-all ${isSecret ? 'border-[#d0bcff] bg-[#d0bcff]/10' : 'border-[#49454f]'}`}
              >
                <div className="flex items-center gap-2"><Lock size={18} /> Modo Sigilo</div>
                <div className={`w-10 h-5 rounded-full relative ${isSecret ? 'bg-[#d0bcff]' : 'bg-[#49454f]'}`}>
                  <div className={`absolute top-1 w-3 h-3 bg-white rounded-full transition-all ${isSecret ? 'left-6' : 'left-1'}`} />
                </div>
              </button>

              <button className="w-full bg-[#d0bcff] text-[#381e72] font-bold py-4 rounded-full shadow-lg flex items-center justify-center gap-2 active:scale-95 transition-transform">
                <Zap size={20} /> Gerar Identidade
              </button>
            </div>
          </div>
        )}

        {currentTab === 'RH' && (
          <div className="space-y-4 animate-in fade-in duration-500">
            <div className="flex justify-between items-center">
              <h2 className="text-2xl font-bold text-[#d0bcff]">Elite Hunter</h2>
              <Leaf size={18} className="text-emerald-400" />
            </div>
            
            <div className="bg-[#49454f]/20 p-4 rounded-3xl border border-slate-800">
              <div className="flex items-center gap-3 mb-4 text-[#938f99]">
                <Search size={16} />
                <span className="text-sm">Buscando melhores funcionários...</span>
              </div>
              
              <div className="space-y-3">
                {[
                  { name: "Sérgio M.", score: 99, role: "Engenharia Verde" },
                  { name: "Beatriz L.", score: 97, role: "Gestor de Sustentabilidade" }
                ].map((c, i) => (
                  <div key={i} className="bg-[#2b2930] p-4 rounded-2xl flex justify-between items-center border border-transparent hover:border-[#d0bcff] transition-colors cursor-pointer">
                    <div className="flex items-center gap-4">
                      <div className="w-10 h-10 bg-[#d0bcff] rounded-full flex items-center justify-center text-[#381e72] font-bold">
                        {c.name[0]}
                      </div>
                      <div>
                        <p className="font-bold">{c.name}</p>
                        <p className="text-xs text-[#938f99]">{c.role}</p>
                      </div>
                    </div>
                    <div className="text-right">
                      <p className="text-xs text-[#d0bcff] font-bold">{c.score}%</p>
                      <ChevronRight size={16} className="text-[#938f99]" />
                    </div>
                  </div>
                ))}
              </div>
            </div>
          </div>
        )}

        {currentTab === 'Carta' && (
          <div className="space-y-4 animate-in fade-in duration-500">
            <h2 className="text-2xl font-bold text-[#d0bcff]">Carta em Branco</h2>
            <div className="bg-[#e6e1e5] text-[#1c1b1f] p-6 rounded-3xl shadow-xl space-y-4 min-h-[300px]">
              <div className="flex items-center gap-2 text-indigo-700 font-bold text-[10px] uppercase tracking-widest">
                <FileText size={12} /> Espaço de Observação
              </div>
              <p className="text-xs text-slate-500 leading-relaxed italic">
                "Este espaço permite que o colaborador contratado registre sua visão sobre inovação tecnológica e bem-estar no setor."
              </p>
              <textarea 
                className="w-full bg-transparent border-none outline-none text-slate-800 h-40 resize-none placeholder:text-slate-300"
                placeholder="Escreva suas observações aqui..."
                value={workerNote}
                onChange={(e) => setWorkerNote(e.target.value)}
              />
            </div>
            <button 
              disabled={!workerNote}
              className="w-full bg-[#d0bcff] text-[#381e72] font-bold py-4 rounded-full disabled:opacity-30 transition-all"
            >
              Submeter Feedback
            </button>
          </div>
        )}

      </main>

      {/* Navigation Bar (Android style) */}
      <footer className="h-20 bg-[#2b2930] flex items-center justify-around border-t border-slate-800 px-2 pb-2">
        <button 
          onClick={() => setCurrentTab('Branding')}
          className={`flex flex-col items-center justify-center gap-1 w-full h-full rounded-2xl transition-colors ${currentTab === 'Branding' ? 'bg-[#4a4458] text-[#d0bcff]' : 'text-[#938f99]'}`}
        >
          <div className={`p-1 px-4 rounded-full ${currentTab === 'Branding' ? 'bg-[#4a4458]' : ''}`}>
            <Zap size={20} fill={currentTab === 'Branding' ? 'currentColor' : 'none'} />
          </div>
          <span className="text-[10px] font-bold">Naming</span>
        </button>

        <button 
          onClick={() => setCurrentTab('RH')}
          className={`flex flex-col items-center justify-center gap-1 w-full h-full rounded-2xl transition-colors ${currentTab === 'RH' ? 'bg-[#4a4458] text-[#d0bcff]' : 'text-[#938f99]'}`}
        >
          <div className={`p-1 px-4 rounded-full ${currentTab === 'RH' ? 'bg-[#4a4458]' : ''}`}>
            <UserCheck size={20} fill={currentTab === 'RH' ? 'currentColor' : 'none'} />
          </div>
          <span className="text-[10px] font-bold">RH Elite</span>
        </button>

        <button 
          onClick={() => setCurrentTab('Carta')}
          className={`flex flex-col items-center justify-center gap-1 w-full h-full rounded-2xl transition-colors ${currentTab === 'Carta' ? 'bg-[#4a4458] text-[#d0bcff]' : 'text-[#938f99]'}`}
        >
          <div className={`p-1 px-4 rounded-full ${currentTab === 'Carta' ? 'bg-[#4a4458]' : ''}`}>
            <FileText size={20} fill={currentTab === 'Carta' ? 'currentColor' : 'none'} />
          </div>
          <span className="text-[10px] font-bold">Carta</span>
        </button>
      </footer>

      {/* Security Banner (Mock) */}
      {isSecret && (
        <div className="bg-amber-900/40 px-4 py-2 flex items-center gap-2 border-t border-amber-900/50">
          <ShieldAlert size={12} className="text-amber-500" />
          <span className="text-[10px] text-amber-500 font-bold uppercase">Sigilo Fonético Ativado</span>
        </div>
      )}
    </div>
  );
};

export default App;
